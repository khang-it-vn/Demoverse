package com.Demoverse.Services;

import com.Demoverse.Entities.ThongKe;
import com.Demoverse.Services.Interface.IThongKe;

import java.util.List;

public class ThongKeService implements IThongKe {
    private List<ThongKe> list;

    @Override
    public List<ThongKe> getAll() {
        return null;
    }

    @Override
    public void add(ThongKe entity) {

    }

    @Override
    public void delete(ThongKe entity) {

    }

    @Override
    public void update(ThongKe entity) {

    }

    public List<ThongKe> getList() {
        return list;
    }

    public void setList(List<ThongKe> list) {
        this.list = list;
    }
}
