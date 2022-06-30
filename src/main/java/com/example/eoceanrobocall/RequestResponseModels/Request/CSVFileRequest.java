package com.example.eoceanrobocall.RequestResponseModels.Request;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@RequiredArgsConstructor
public class CSVFileRequest {
    private String caller_id;
    private String order_id;
    private String shipment;
    private String amount;
    private String acc_num;
    private String due_date;
}
