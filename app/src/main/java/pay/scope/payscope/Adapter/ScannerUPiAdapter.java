package pay.scope.payscope.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import pay.scope.payscope.Activity.ChatsActivity;
import pay.scope.payscope.Model.ScannerBottomModel;
import pay.scope.payscope.R;

public class ScannerUPiAdapter extends RecyclerView.Adapter<ScannerUPiAdapter.ViewHolder> {
    private final Context context;
    private final List<ScannerBottomModel> scannerBottomModelList;

    public ScannerUPiAdapter(Context context, List<ScannerBottomModel> scannerBottomModelList) {
        this.context = context;
        this.scannerBottomModelList = scannerBottomModelList;
    }

    @NonNull
    @Override
    public ScannerUPiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.scanner_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScannerUPiAdapter.ViewHolder holder, int position) {
        ScannerBottomModel scannerBottomModel = scannerBottomModelList.get(position);
        holder.ScannerBottomNames.setText(scannerBottomModel.getScannerBottomName());
        holder.ScannerBottomImgs.setImageResource(scannerBottomModel.getScannerBottomImg());

        holder.ScannerBottomCard.setCardBackgroundColor(context.getResources().getColor(scannerBottomModel.getScannerBottomCardColor()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChatsActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return scannerBottomModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ScannerBottomImgs;
        TextView ScannerBottomNames;
        CardView ScannerBottomCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ScannerBottomImgs = itemView.findViewById(R.id.ScannerBottomImg);
            ScannerBottomNames = itemView.findViewById(R.id.ScannerBottomName);
            ScannerBottomCard = itemView.findViewById(R.id.ScannerBottomCard);
        }
    }
}
