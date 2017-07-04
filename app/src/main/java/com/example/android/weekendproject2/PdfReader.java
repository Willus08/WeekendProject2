package com.example.android.weekendproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfReader extends AppCompatActivity {

    private PDFView pdfReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);
        pdfReader= (PDFView) findViewById(R.id.pdfReader);
        pdfReader.fromAsset("test.pdf").load();
    }
}
