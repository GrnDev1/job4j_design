package ru.job4j.ood.isp.ex3;

public class RZDCompany implements ProductCompany {
    @Override
    public int getOnlineSales() {
        return 200;
    }

    @Override
    public int getOfflineSales() {
        return 100;
    }
}
