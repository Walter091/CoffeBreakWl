package com.example.coffeBreakWL.natives;

public class NativeQueryConfig implements io.github.gasparbarancelli.NativeQueryConfig {

    @Override
    public String getPackageScan() {
        return "io.github.Walter091.CoffeBreakWl";
    }

    @Override
    public String getFileSufix() {
        return "sql";
    }

    @Override
    public String getSQLDirectory() {
        return "nativeQuery/";
    }

    @Override
    public boolean getUseHibernateTypes() {
        return false;
    }
}
