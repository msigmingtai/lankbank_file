package com.lankbank_file.Entity;

import lombok.Data;

@Data
public class OutEntity
{
    private String COMP;// 固定108 05
    private String ACCP_NO;// 受理編號 37
    private String PLY_NO;// 保單號 62
    private String TYPE;// 險種代碼 72
    private String TYPE_DETAIL;// 細險種代碼82
    private int COMM_DAY;// 資料產生日90
    private int EFF_DAY;// 生效日 98
    private int EXP_DAY;// 到期日 106
    private String SITU_TYPE;// 受理狀況 107
    private String PLY_TYPE;// 保單狀況 109
    private String CONTENT;// 批改內容 169
    private String RENEW;// 是否續保 170
    private String FASR_NAME;// 要保人姓名200
    private String FASR_ID;// 要保人ID 212
    private String AREA;// 郵遞區號 217
    private String ADDR;// 通訊地址 297
    private String CNAME;// 被保人姓名329
    private String ID;// 被保人ID 341
    private String BIRTH;// 被保人生日349
    private String YEAR;// 投保年齡 352
    private String FILLER;// 繳別 354
    private String PREM;// 保費 366
    private String AMT;// 保額 380
    private String FILLER2;// 詢價固定放381
    private String COMI_RATE;// 佣金率 387
    private String FILLER1;// 固定001 390
    private String AGENT_UNIT;// 外部分行 393
    private String AUTO;// 保固定0 394
    private String OVER;// 足額 395
    private String FILLER3;// 引擎號 425
    private String ORG_PLY;// 續保號 450
    private int ORG_EXP;// 續保號到期日458
    private String FILLER4;// 專案代碼(空白459
    private String FILLER5;// 460

}
