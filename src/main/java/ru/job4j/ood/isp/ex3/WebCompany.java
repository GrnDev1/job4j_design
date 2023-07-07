package ru.job4j.ood.isp.ex3;

public class WebCompany implements ProductCompany {
    @Override
    public int getOnlineSales() {
        return 300;
    }

    @Override
    public int getOfflineSales() {
        throw new UnsupportedOperationException();
    }
}
