package bg.tu_varna.sit.issuapplication.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bg.tu_varna.sit.issuapplication.R;

public class IssueViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;
    public IssueViewHolder(@NonNull View itemView) {
        super(itemView);

        this.textView = itemView.findViewById(R.id.textView2);
    }

    public void setTextView(String address) {
        this.textView.setText(address);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.itemView.setOnClickListener(listener);
    }

    public void  setBackgroundColor(int color) {
        this.itemView.setBackgroundColor(color);
    }
}
