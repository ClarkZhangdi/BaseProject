package com.clark.basemodel.view.recyclerview.helper;

/**
 *  Created By Clark
 *  Description : 配合RecyclerViewTouchMoveCallBack 发生数据改变是被调用的方法
 *  @date 2019/4/1.
 */
public interface DataChangeListener {
    void itemMovedListener(int movePosition, int targetPosition);
}
