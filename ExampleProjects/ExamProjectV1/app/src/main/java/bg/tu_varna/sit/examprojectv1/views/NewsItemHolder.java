package bg.tu_varna.sit.examprojectv1.views;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bg.tu_varna.sit.examprojectv1.R;

public class NewsItemHolder extends RecyclerView.ViewHolder {

    private TextView tittle, content;

    public NewsItemHolder(@NonNull View itemView) {
        super(itemView);
        tittle = itemView.findViewById(R.id.textView);
        content = itemView.findViewById(R.id.textView2);
    }

    public void setTittle(String tittle) {
        this.tittle.setText(tittle);
    }

    public void setContent(String content) {
        this.content.setText(content);
    }

    public void setOnLongClickListener(String title) {
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(itemView.getContext(), title, Toast.LENGTH_LONG);
                return false;
            }
        });
    }
}
