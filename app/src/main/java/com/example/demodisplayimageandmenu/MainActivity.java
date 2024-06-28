package com.example.demodisplayimageandmenu;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//    private TextView textView;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textView = findViewById(R.id.textView);
//        registerForContextMenu(textView);
//    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.context_menu, menu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        int itemId = item.getItemId();
//        int editId = R.id.item_edit;
//        int deleteId = R.id.item_delete;
//
//        if (itemId == editId) {
//            Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
//            return true;
//        } else if (itemId == deleteId) {
//            Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
//            return true;
//        } else {
//            return super.onContextItemSelected(item);
//        }
//    }

    ListView listView;
    String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, items);
        listView.setAdapter(adapter);

        //Tìm ListView trong layout bằng ID và gán vào biến listView.
        //Tạo một ArrayAdapter để liên kết mảng items với ListView. ArrayAdapter sẽ biến mỗi item trong mảng thành một view trong ListView.
        //android.R.layout.simple_list_item_activated_1 là layout mặc định cho mỗi hàng trong ListView, cho phép hiển thị trạng thái khi hàng được chọn.

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            //setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL): Thiết lập chế độ chọn cho ListView để kích hoạt Contextual Action Mode khi có một hoặc nhiều item được chọn.
            //setMultiChoiceModeListener: Đăng ký một listener để xử lý các sự kiện trong Contextual Action Mode, bao gồm việc thay đổi trạng thái chọn của các item, tạo và hủy Action Mode, và xử lý các click vào menu.
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // Cập nhật tiêu đề dựa trên số lượng mục được chọn
                final int checkedCount = listView.getCheckedItemCount();
                mode.setTitle(checkedCount + " Selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Khởi tạo Contextual Action Mode bằng cách inflate menu từ XML.
                mode.getMenuInflater().inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;

                //trả về false khi không có gì được thực hiện
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.delete) {
                    // Xử lý khi chọn Xóa
                    mode.finish(); // Đóng Action Mode
                    return true;
                } else if (itemId == R.id.share) {
                    // Xử lý khi chọn Chia sẻ
                    mode.finish(); // Đóng Action Mode
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                mode = null;
            }
        });
    }
}