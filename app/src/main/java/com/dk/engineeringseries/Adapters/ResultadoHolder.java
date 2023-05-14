package com.dk.engineeringseries.Adapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dk.engineeringseries.R;

public class ResultadoHolder extends RecyclerView.ViewHolder {
    private TextView txtResult;
    private TextView txtArea1;
    private TextView txtDescArea1;
    private TextView txtArea2;
    private TextView txtDescArea2;
    private TextView txtArea3;
    private TextView txtDescArea3;
    private ImageView imgTrilha1;
    private TextView txtTrilha1;
    private TextView txtDescTrilha1;
    private ImageView imgTrilha2;
    private TextView txtTrilha2;
    private TextView txtDescTrilha2;
    private ImageView imgTrilha3;
    private TextView txtTrilha3;
    private TextView txtDescTrilha3;
    private Button btnTrilha1;
    private Button btnTrilha2;
    private Button btnTrilha3;

    private ImageView imgResult;



    public ResultadoHolder(@NonNull View itemView) {
        super(itemView);
        txtResult = (TextView) itemView.findViewById(R.id.txtResult);
        txtArea1 = (TextView) itemView.findViewById(R.id.txtArea1);
        txtDescArea1 = (TextView) itemView.findViewById(R.id.txtDescArea1);
        txtArea2 = (TextView) itemView.findViewById(R.id.txtArea2);
        txtDescArea2 = (TextView) itemView.findViewById(R.id.txtDescArea2);
        txtArea3 = (TextView) itemView.findViewById(R.id.txtArea3);
        txtDescArea3 = (TextView) itemView.findViewById(R.id.txtDescArea3);
        imgTrilha1 = (ImageView) itemView.findViewById(R.id.imgTrilha1);
        txtTrilha1 = (TextView) itemView.findViewById(R.id.txtTrilha1);
        txtDescTrilha1 = (TextView) itemView.findViewById(R.id.txtDescTrilha1);
        imgTrilha2 = (ImageView) itemView.findViewById(R.id.imgTrilha2);
        txtTrilha2 = (TextView) itemView.findViewById(R.id.txtTrilha2);
        txtDescTrilha2 = (TextView) itemView.findViewById(R.id.txtDescTrilha2);
        imgTrilha3 = (ImageView) itemView.findViewById(R.id.imgTrilha3);
        txtTrilha3 = (TextView) itemView.findViewById(R.id.txtTrilha3);
        txtDescTrilha3= (TextView) itemView.findViewById(R.id.txtDescTrilha3);
        btnTrilha1 = (Button) itemView.findViewById(R.id.btnTrilha1);
        btnTrilha2 = (Button) itemView.findViewById(R.id.btnTrilha2);
        btnTrilha3 = (Button) itemView.findViewById(R.id.btnTrilha3);
        imgResult = (ImageView) itemView.findViewById(R.id.imgResult);
    }

    public TextView getTxtResult() {
        return txtResult;
    }

    public void setTxtResult(TextView txtResult) {
        this.txtResult = txtResult;
    }

    public TextView getTxtArea1() {
        return txtArea1;
    }

    public void setTxtArea1(TextView txtArea1) {
        this.txtArea1 = txtArea1;
    }

    public TextView getTxtDescArea1() {
        return txtDescArea1;
    }

    public void setTxtDescArea1(TextView txtDescArea1) {
        this.txtDescArea1 = txtDescArea1;
    }

    public TextView getTxtArea2() {
        return txtArea2;
    }

    public void setTxtArea2(TextView txtArea2) {
        this.txtArea2 = txtArea2;
    }

    public TextView getTxtDescArea2() {
        return txtDescArea2;
    }

    public void setTxtDescArea2(TextView txtDescArea2) {
        this.txtDescArea2 = txtDescArea2;
    }

    public TextView getTxtArea3() {
        return txtArea3;
    }

    public void setTxtArea3(TextView txtArea3) {
        this.txtArea3 = txtArea3;
    }

    public TextView getTxtDescArea3() {
        return txtDescArea3;
    }

    public void setTxtDescArea3(TextView txtDescArea3) {
        this.txtDescArea3 = txtDescArea3;
    }

    public ImageView getImgTrilha1() {
        return imgTrilha1;
    }

    public void setImgTrilha1(ImageView imgTrilha1) {
        this.imgTrilha1 = imgTrilha1;
    }

    public TextView getTxtTrilha1() {
        return txtTrilha1;
    }

    public void setTxtTrilha1(TextView txtTrilha1) {
        this.txtTrilha1 = txtTrilha1;
    }

    public TextView getTxtDescTrilha1() {
        return txtDescTrilha1;
    }

    public void setTxtDescTrilha1(TextView txtDescTrilha1) {
        this.txtDescTrilha1 = txtDescTrilha1;
    }

    public ImageView getImgTrilha2() {
        return imgTrilha2;
    }

    public void setImgTrilha2(ImageView imgTrilha2) {
        this.imgTrilha2 = imgTrilha2;
    }

    public TextView getTxtTrilha2() {
        return txtTrilha2;
    }

    public void setTxtTrilha2(TextView txtTrilha2) {
        this.txtTrilha2 = txtTrilha2;
    }

    public TextView getTxtDescTrilha2() {
        return txtDescTrilha2;
    }

    public void setTxtDescTrilha2(TextView txtDescTrilha2) {
        this.txtDescTrilha2 = txtDescTrilha2;
    }

    public ImageView getImgTrilha3() {
        return imgTrilha3;
    }

    public void setImgTrilha3(ImageView imgTrilha3) {
        this.imgTrilha3 = imgTrilha3;
    }

    public TextView getTxtTrilha3() {
        return txtTrilha3;
    }

    public void setTxtTrilha3(TextView txtTrilha3) {
        this.txtTrilha3 = txtTrilha3;
    }

    public TextView getTxtDescTrilha3() {
        return txtDescTrilha3;
    }

    public void setTxtDescTrilha3(TextView txtDescTrilha3) {
        this.txtDescTrilha3 = txtDescTrilha3;
    }

    public Button getBtnTrilha1() {
        return btnTrilha1;
    }

    public void setBtnTrilha1(Button btnTrilha1) {
        this.btnTrilha1 = btnTrilha1;
    }

    public Button getBtnTrilha2() {
        return btnTrilha2;
    }

    public void setBtnTrilha2(Button btnTrilha2) {
        this.btnTrilha2 = btnTrilha2;
    }

    public Button getBtnTrilha3() {
        return btnTrilha3;
    }

    public void setBtnTrilha3(Button btnTrilha3) {
        this.btnTrilha3 = btnTrilha3;
    }

    public ImageView getImgResult() {
        return imgResult;
    }

    public void setImgResult(ImageView imgResult) {
        this.imgResult = imgResult;
    }
}
