package com.magicsoft.daybyday.factory.simple.normal;

public class Magotan extends FAWVolkswagen{
    public static final int ID = 3;

    @Override
    public void drive() {
        System.out.println("Magotan 开出去咯，测试成功了");
    }

    @Override
    public String getName() {
        return "Magotan";
    }

    @Override
    public void brake(){
        System.out.println("Magotan 刹车挺好的，测试通过");
    }
}