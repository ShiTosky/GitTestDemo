package com.nalan.swipeitem;

import java.util.List;
import java.util.Map;

/**
 * Created by ShiLiang on 2018/4/20.
 */

public class RespDao {
    private int id;
    private String respStr;
    private List<Integer> toWorkerList;
    private List<Map<String,Object>> toWorkerIdList;

    public List<Map<String, Object>> getToWorkerIdList() {
        return toWorkerIdList;
    }

    public void setToWorkerIdList(List<Map<String, Object>> toWorkerIdList) {
        this.toWorkerIdList = toWorkerIdList;
    }

    public List<Integer> getToWorkerList() {
        return toWorkerList;
    }

    public void setToWorkerList(List<Integer> toWorkerList) {
        this.toWorkerList = toWorkerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRespStr() {
        return respStr;
    }

    public void setRespStr(String respStr) {
        this.respStr = respStr;
    }
}
