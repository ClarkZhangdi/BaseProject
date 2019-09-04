package com.clark.basemodel.view.recyclerview.helper;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created By Clark
 * Description :一个用于更简单设置以及数据回调的callBack,期望动画平滑,实现真实数据交换.
 *
 * @date 2019/4/1.
 */
public class RecyclerViewTouchMoveCallBack extends ItemTouchHelper.Callback {

    private DataChangeListener dataChangeListener;

    public void setDataChangeListener(DataChangeListener dataChangeListener) {
        this.dataChangeListener = dataChangeListener;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        /*拖拽Flag 和 侧滑删除Flag 传0表示不支持滑动*/
        int dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.UP | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN;
        int swipFlags = ItemTouchHelper.LEFT | ItemTouchHelper.UP | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN;
        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        /*长按一定的Position*/
        int movePosition = viewHolder.getAdapterPosition();
        /*目标Position*/
        int targetPosition = target.getAdapterPosition();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            /*界面改变,真实数据不变*/
            adapter.notifyItemMoved(movePosition, targetPosition);
            /**/
            if (dataChangeListener != null)
                dataChangeListener.itemMovedListener(movePosition, targetPosition);
            return true;
        } else
            return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        /*滑动*/
    }
}
