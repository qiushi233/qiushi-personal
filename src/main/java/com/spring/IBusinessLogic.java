package com.spring;

/**
 * Created by qiushi on 16/5/9.
 */

public interface IBusinessLogic {

    public void foo();

    public void bar() throws BusinessLogicException;

    public long time();
}
