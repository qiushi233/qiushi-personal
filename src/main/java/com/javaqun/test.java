package com.javaqun;


public class test {

	public static final int X = 10;//���̿�
	public static final int Y = 10;//���̸�
	public static final int BOMBNUM = 10;//��������
	public static final String BOMBFLAG="*";//���ױ�ʶ��
	
	public static Object[][] bombPos = new Object[X][Y];//��ʵ���ݵ�����
	
	public static Object[][] board=new Object[X][Y]; //��ʾ������

	public static void main(String[] args) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j]==null){
					System.out.print("+");
				}else{
					System.out.print(board[i][j]);
				}
			}
			System.out.println();
		}
		
	}
	
	public static void input(int inputx,int inputy){
		
	}

	//��ʼ������
	public static void init() {
		int bombx, bomby;//���׵�xy����
		int b=0;//�����ɵĵ�������
		//������ɵ�������
		while (b != BOMBNUM) {
			bombx = (int) (Math.random() * X);
			bomby = (int) (Math.random() * X);
			if ("*".equals(bombPos[bombx][bomby])) {//���������ظ�
				continue;
			}
			bombPos[bombx][bomby] = "*";//�������������ʵ����
			b++;
		}
		
		//������ά���飨��ʵ���̣�
		for(int i=0;i<bombPos.length;i++){
			for(int j=0;j<bombPos[i].length;j++){
				//�����ǰ�����ǵ��ף����˳���ǰѭ��
				if("*".equals(bombPos[i][j])){
					continue;
				}
				bombPos[i][j]=hasBomb(i,j);//��ֵ����ǰ���꣬��ʾ��Χ���ڵĵ���
			}
		}
	}
	
	//��Χ�Ƿ���ڵ���
	public static int hasBomb(int x,int y){
		int bombnum=0;
		for(int i=-1;i<1;i++){
			for(int j=-1;j<1;j++){
				if(x+i>=0&&x+i<X&&y+j>=0&&y+j<Y){
					if("*".equals(bombPos[x+i][y+j])){
						bombnum++;
					}
				}
			}
		}
		return bombnum;
	}
	
	
	//��ӡ������
	public static void print(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j]==null){
					System.out.print("+");//δ����ĸ�����+����
				}else{
					System.out.print(board[i][j]);
				}
			}
			System.out.println();
		}
	}
	
}
