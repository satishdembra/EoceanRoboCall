package com.example.eoceanrobocall.RequestResponseModels.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseStats {
    int Answer;
    int NoAnswer;
    int Hangup;
    int Congestion;
    int Busy;
    int DTMF;
}
