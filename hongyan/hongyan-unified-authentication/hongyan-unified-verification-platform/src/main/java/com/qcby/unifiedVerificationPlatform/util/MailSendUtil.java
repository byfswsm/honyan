package com.qcby.unifiedVerificationPlatform.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 发送邮箱工具
 */
@Slf4j
public class MailSendUtil {

    /**
     * 主要过程
     *
     * @param email
     */
    public static void sendMsg(String email) {
        String code = CodeUtil.getCode();
        //放入map中
        CodeUtil.getLoginCodeMap().put(email, code);

        log.info("CodeUtil.getLoginMap()-------"+CodeUtil.getLoginCodeMap());

        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("1229505432@qq.com");
        account.setUser("1229505432@qq.com");
        account.setPass("kjuhjteetsfkhjcg");
        MailUtil.send(account, CollUtil.newArrayList(email), "来自野男人网站的验证码", getContent(code), true);

        //得到手机号或者邮箱之后,设置两分钟自动删除Map表中验证码数据
//        CodeUtil.delayDeleteUserCode(email);====>更改为注解删除email
    }



    /**
     * 文章内容->html格式
     *
     * @return
     */
    private static String getContent(String code) {
        String s = "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n" +
                "    <style type=\"text/css\">\n" +
                "        /*** BMEMBF Start ***/\n" +
                "        \n" +
                "        [name=bmeMainBody] {\n" +
                "            min-height: 1000px;\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.blk,\n" +
                "            table.tblText,\n" +
                "            .bmeHolder,\n" +
                "            .bmeHolder1,\n" +
                "            table.bmeMainColumn {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeImageCard table.bmeCaptionTable td.tblCell {\n" +
                "                padding: 0px 20px 20px 20px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeImageCard table.bmeCaptionTable.bmeCaptionTableMobileTop td.tblCell {\n" +
                "                padding: 20px 20px 0 20px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.bmeCaptionTable td.tblCell {\n" +
                "                padding: 10px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.tblGtr {\n" +
                "                padding-bottom: 20px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            td.blk_container,\n" +
                "            .blk_parent,\n" +
                "            .bmeLeftColumn,\n" +
                "            .bmeRightColumn,\n" +
                "            .bmeColumn1,\n" +
                "            .bmeColumn2,\n" +
                "            .bmeColumn3,\n" +
                "            .bmeBody {\n" +
                "                display: table !important;\n" +
                "                max-width: 600px !important;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.container-table,\n" +
                "            .bmeheadertext,\n" +
                "            .container-table {\n" +
                "                width: 95% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .mobile-footer,\n" +
                "            .mobile-footer a {\n" +
                "                font-size: 13px !important;\n" +
                "                line-height: 18px !important;\n" +
                "            }\n" +
                "            .mobile-footer {\n" +
                "                text-align: center !important;\n" +
                "            }\n" +
                "            table.share-tbl {\n" +
                "                padding-bottom: 15px;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "            table.share-tbl td {\n" +
                "                display: block !important;\n" +
                "                text-align: center !important;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            td.bmeShareTD,\n" +
                "            td.bmeSocialTD {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            td.tdBoxedTextBorder {\n" +
                "                width: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.blk,\n" +
                "            table[name=tblText],\n" +
                "            .bmeHolder,\n" +
                "            .bmeHolder1,\n" +
                "            table[name=bmeMainColumn] {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeImageCard table.bmeCaptionTable td[name=tblCell] {\n" +
                "                padding: 0px 20px 20px 20px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeImageCard table.bmeCaptionTable.bmeCaptionTableMobileTop td[name=tblCell] {\n" +
                "                padding: 20px 20px 0 20px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.bmeCaptionTable td[name=tblCell] {\n" +
                "                padding: 10px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table[name=tblGtr] {\n" +
                "                padding-bottom: 20px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            td.blk_container,\n" +
                "            .blk_parent,\n" +
                "            [name=bmeLeftColumn],\n" +
                "            [name=bmeRightColumn],\n" +
                "            [name=bmeColumn1],\n" +
                "            [name=bmeColumn2],\n" +
                "            [name=bmeColumn3],\n" +
                "            [name=bmeBody] {\n" +
                "                display: table !important;\n" +
                "                max-width: 600px !important;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table[class=container-table],\n" +
                "            .bmeheadertext,\n" +
                "            .container-table {\n" +
                "                width: 95% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .mobile-footer,\n" +
                "            .mobile-footer a {\n" +
                "                font-size: 13px !important;\n" +
                "                line-height: 18px !important;\n" +
                "            }\n" +
                "            .mobile-footer {\n" +
                "                text-align: center !important;\n" +
                "            }\n" +
                "            table[class=\"share-tbl\"] {\n" +
                "                padding-bottom: 15px;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "            table[class=\"share-tbl\"] td {\n" +
                "                display: block !important;\n" +
                "                text-align: center !important;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            td[name=bmeShareTD],\n" +
                "            td[name=bmeSocialTD] {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            td[name=tdBoxedTextBorder] {\n" +
                "                width: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeImageCard table.bmeImageTable {\n" +
                "                height: auto !important;\n" +
                "                width: 100% !important;\n" +
                "                padding: 20px !important;\n" +
                "                clear: both;\n" +
                "                float: left !important;\n" +
                "                border-collapse: separate;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblInline table.bmeImageTable {\n" +
                "                height: auto !important;\n" +
                "                width: 100% !important;\n" +
                "                padding: 10px !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblInline table.bmeCaptionTable {\n" +
                "                width: 100% !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.bmeImageTable {\n" +
                "                height: auto !important;\n" +
                "                width: 100% !important;\n" +
                "                padding: 10px !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.bmeCaptionTable {\n" +
                "                width: 100% !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.bmeImageContainer {\n" +
                "                width: 100% !important;\n" +
                "                clear: both;\n" +
                "                float: left !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.bmeImageTable td {\n" +
                "                padding: 0px !important;\n" +
                "                height: auto;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            img.mobile-img-large {\n" +
                "                width: 100% !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            img.bmeRSSImage {\n" +
                "                max-width: 320px;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (min-width: 640px) {\n" +
                "            img.bmeRSSImage {\n" +
                "                max-width: 600px !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .trMargin img {\n" +
                "                height: 10px;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            div.bmefooter,\n" +
                "            div.bmeheader {\n" +
                "                display: block !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .tdPart {\n" +
                "                width: 100% !important;\n" +
                "                clear: both;\n" +
                "                float: left !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            table.blk_parent1,\n" +
                "            table.tblPart {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .tblLine {\n" +
                "                min-width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblCenter img {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblCenter,\n" +
                "            .bmeMblCenter div,\n" +
                "            .bmeMblCenter span {\n" +
                "                text-align: center !important;\n" +
                "                text-align: -webkit-center !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeNoBr br,\n" +
                "            .bmeImageGutterRow,\n" +
                "            .bmeMblStackCenter .bmeShareItem .tdMblHide {\n" +
                "                display: none !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblInline table.bmeImageTable,\n" +
                "            .bmeMblInline table.bmeCaptionTable,\n" +
                "            td.bmeMblInline {\n" +
                "                clear: none !important;\n" +
                "                width: 50% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblInlineHide,\n" +
                "            .bmeShareItem .trMargin {\n" +
                "                display: none !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblInline table.bmeImageTable img,\n" +
                "            .bmeMblShareCenter.tblContainer.mblSocialContain,\n" +
                "            .bmeMblFollowCenter.tblContainer.mblSocialContain {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblStack>.bmeShareItem {\n" +
                "                width: 100% !important;\n" +
                "                clear: both !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeShareItem {\n" +
                "                padding-top: 10px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .tdPart.bmeMblStackCenter,\n" +
                "            .bmeMblStackCenter .bmeFollowItemIcon {\n" +
                "                padding: 0px !important;\n" +
                "                text-align: center !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblStackCenter>.bmeShareItem {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            td.bmeMblCenter {\n" +
                "                border: 0 none transparent !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeLinkTable.tdPart td {\n" +
                "                padding-left: 0px !important;\n" +
                "                padding-right: 0px !important;\n" +
                "                border: 0px none transparent !important;\n" +
                "                padding-bottom: 15px !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .tdMblHide {\n" +
                "                width: 10px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeShareItemBtn {\n" +
                "                display: table !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblStack td {\n" +
                "                text-align: left !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblStack .bmeFollowItem {\n" +
                "                clear: both !important;\n" +
                "                padding-top: 10px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblStackCenter .bmeFollowItemText {\n" +
                "                padding-left: 5px !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .bmeMblStackCenter .bmeFollowItem {\n" +
                "                clear: both !important;\n" +
                "                align-SelfController: center;\n" +
                "                float: none !important;\n" +
                "                padding-top: 10px;\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .tdPart>table {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .tdPart>table.bmeLinkContainer {\n" +
                "                width: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 480px) {\n" +
                "            .tdPart.mblStackCenter>table.bmeLinkContainer {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        .blk_parent:first-child,\n" +
                "        .blk_parent {\n" +
                "            float: left;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_parent:last-child {\n" +
                "            float: right;\n" +
                "        }\n" +
                "        /*** BMEMBF END ***/\n" +
                "        \n" +
                "        table[name=\"bmeMainBody\"],\n" +
                "        body {\n" +
                "            background-color: #cadcca;\n" +
                "        }\n" +
                "        \n" +
                "        td[name=\"bmePreHeader\"] {\n" +
                "            background-color: transparent;\n" +
                "        }\n" +
                "        \n" +
                "        td[name=\"bmeHeader\"] {\n" +
                "            background: #ffffff;\n" +
                "            background-color: #2b2b2b;\n" +
                "        }\n" +
                "        \n" +
                "        td[name=\"bmeBody\"],\n" +
                "        table[name=\"bmeBody\"] {\n" +
                "            background-color: #e2e2e2;\n" +
                "        }\n" +
                "        \n" +
                "        td[name=\"bmePreFooter\"] {\n" +
                "            background-color: #ffffff;\n" +
                "        }\n" +
                "        \n" +
                "        td[name=\"bmeFooter\"] {\n" +
                "            background-color: transparent;\n" +
                "        }\n" +
                "        \n" +
                "        td[name=\"tblCell\"],\n" +
                "        .blk {\n" +
                "            font-family: initial;\n" +
                "            font-weight: normal;\n" +
                "            font-size: initial;\n" +
                "        }\n" +
                "        \n" +
                "        table[name=\"blk_blank\"] td[name=\"tblCell\"] {\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "            font-size: 14px;\n" +
                "        }\n" +
                "        \n" +
                "        [name=bmeMainContentParent] {\n" +
                "            border-color: #666666;\n" +
                "            border-width: 0px;\n" +
                "            border-style: none;\n" +
                "            border-radius: 0px;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        \n" +
                "        [name=bmeMainColumnParent] {\n" +
                "            border-color: transparent;\n" +
                "            border-width: 0px;\n" +
                "            border-style: none;\n" +
                "            border-radius: 0px;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 0px;\n" +
                "            overflow: visible;\n" +
                "        }\n" +
                "        \n" +
                "        [name=bmeMainColumn] {\n" +
                "            border-color: transparent;\n" +
                "            border-width: 0px;\n" +
                "            border-style: none;\n" +
                "            border-radius: 0px;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 0px;\n" +
                "            overflow: visible;\n" +
                "        }\n" +
                "        \n" +
                "        [name=bmeMainContent] {\n" +
                "            border-color: transparent;\n" +
                "            border-width: 0px;\n" +
                "            border-style: none;\n" +
                "            border-radius: 0px;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 0px;\n" +
                "            overflow: visible;\n" +
                "        }\n" +
                "        \n" +
                "        [name=bmeMainColumnParentTable] {\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 0px;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <!--[if gte mso 9]>    \n" +
                "  <xml>    \n" +
                "  <o:OfficeDocumentSettings>    \n" +
                "  <o:AllowPNG/>    \n" +
                "  <o:PixelsPerInch>96</o:PixelsPerInch>    \n" +
                "  </o:OfficeDocumentSettings>    \n" +
                "  </xml>    \n" +
                "  <![endif]-->\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body marginheight=\"0\" marginwidth=\"0\" topmargin=\"0\" leftmargin=\"0\" style=\"height: 100% !important; margin: 0; padding: 0; width: 100% !important;min-width: 100%;\">\n" +
                "    <style type=\"text/css\">\n" +
                "        body {\n" +
                "            height: 100%;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_dd_wrap {\n" +
                "            background: #f5f5f7;\n" +
                "            padding: 40px 0;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop {\n" +
                "            border: 2px dashed #e6e6e8;\n" +
                "            border-radius: 6px;\n" +
                "            color: #9ca8af;\n" +
                "            margin: 0 auto;\n" +
                "            overflow: hidden;\n" +
                "            padding: 10px;\n" +
                "            position: relative;\n" +
                "            max-width: 210px;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_icon {\n" +
                "            background: url('/images/icn/img-block-dd.png') no-repeat top;\n" +
                "            display: inline-block;\n" +
                "            float: left;\n" +
                "            height: 65px;\n" +
                "            margin-right: 10px;\n" +
                "            width: 65px;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_txt_wrap {\n" +
                "            float: left;\n" +
                "            max-width: 135px;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_txt {\n" +
                "            font-size: 22px;\n" +
                "            font-weight: bold;\n" +
                "            line-height: 26px;\n" +
                "            margin: 5px 0;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_link {\n" +
                "            font-size: 13px;\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_link a {\n" +
                "            color: #16a7e0;\n" +
                "            cursor: pointer;\n" +
                "            font-weight: 600;\n" +
                "            margin-left: 5px;\n" +
                "            text-decoration: underline;\n" +
                "            text-transform: lowercase;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_link a:hover {\n" +
                "            color: #72c2a1;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_txt.no-dd {\n" +
                "            display: none;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_link.no-dd span {\n" +
                "            display: none;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_img_drop_link.no-dd a {\n" +
                "            font-size: 14px;\n" +
                "            display: inline-block;\n" +
                "            margin-left: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        \n" +
                "        .ie8 .blk_img_drop_link.no-dd a {\n" +
                "            padding-top: 20px;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_vid_dd_wrap {\n" +
                "            background: #f5f5f7;\n" +
                "            padding: 40px 0;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_vid_dd {\n" +
                "            border: 2px solid #e6e6e8;\n" +
                "            border-radius: 6px;\n" +
                "            display: inline-block;\n" +
                "            padding: 10px 12px;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_vid_txt {\n" +
                "            color: #16a7e0;\n" +
                "            cursor: pointer;\n" +
                "            font-size: 20px;\n" +
                "            font-weight: 600;\n" +
                "            line-height: 40px;\n" +
                "            text-decoration: underline;\n" +
                "        }\n" +
                "        \n" +
                "        .blk_vid_txt:before {\n" +
                "            background: url('/images/icn/editor-video-play.png') no-repeat center;\n" +
                "            border: 4px solid #9ca8af;\n" +
                "            border-radius: 8px;\n" +
                "            content: '';\n" +
                "            display: inline-block;\n" +
                "            float: left;\n" +
                "            height: 39px;\n" +
                "            width: 39px;\n" +
                "            margin-right: 10px;\n" +
                "        }\n" +
                "        \n" +
                "        @media screen {\n" +
                "            @media (min-width: 0px) {\n" +
                "                .blk_img_drop_icon {\n" +
                "                    background-image: url('/images/icn/img-block-dd.svg');\n" +
                "                    background-size: 65px 65px;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "\n" +
                "    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" name=\"bmeMainBody\" style=\"background-color: rgb(20,20,34);\" bgcolor=\"#cadcca\">\n" +
                "        <tbody>\n" +
                "            <tr>\n" +
                "                <td width=\"100%\" valign=\"top\" align=\"center\">\n" +
                "                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" name=\"bmeMainColumnParentTable\" style=\"border-collapse: separate; border-spacing: 0px;\">\n" +
                "                        <tbody>\n" +
                "                            <tr>\n" +
                "                                <td name=\"bmeMainColumnParent\" style=\"border: 0px none transparent; border-radius: 0px; border-collapse: separate; border-spacing: 0px; overflow: visible;\">\n" +
                "                                    <table name=\"bmeMainColumn\" class=\"bmeHolder bmeMainColumn\" style=\"max-width: 600px; overflow: visible; border-radius: 0px; border-collapse: separate; border-spacing: 0px;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n" +
                "                                        <tbody>\n" +
                "                                            <tr>\n" +
                "                                                <td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmePreHeader\" valign=\"top\" align=\"center\" style=\"color: rgb(102, 102, 102); border: 0px none transparent;\" bgcolor=\"\">\n" +
                "                                                    <div id=\"dv_1\" class=\"blk_wrapper\">\n" +
                "                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"tblCellMain\" style=\"padding-top:20px; padding-bottom:20px;padding-left:20px;padding-right:20px;\">\n" +
                "                                                                        <table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top: 0px solid rgb(225, 225, 225); min-width: 1px;\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td><span></span></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </div>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                            <tr>\n" +
                "                                                <td width=\"100%\" class=\"bmeHolder\" valign=\"top\" align=\"center\" name=\"bmeMainContentParent\" style=\"border: 0px none rgb(102, 102, 102); border-radius: 0px; border-collapse: separate; border-spacing: 0px; overflow: hidden;\">\n" +
                "                                                    <table name=\"bmeMainContent\" style=\"border-radius: 0px; border-collapse: separate; border-spacing: 0px; border: 0px none transparent; overflow: visible;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n" +
                "                                                        <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                                <td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmeHeader\" valign=\"top\" align=\"center\" style=\"color: rgb(56, 56, 56); border: 0px none transparent; background-color: rgb(43, 43, 43);\" bgcolor=\"#2b2b2b\">\n" +
                "                                                                    <div id=\"dv_7\" class=\"blk_wrapper\">\n" +
                "                                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"tblCellMain\" style=\"padding-top:20px; padding-bottom:20px;padding-left:20px;padding-right:20px;\">\n" +
                "                                                                                        <table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td><span></span></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </div>\n" +
                "                                                                    <div id=\"dv_9\" class=\"blk_wrapper\">\n" +
                "                                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_text\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td>\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"bmeContainerRow\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td class=\"tdPart\" valign=\"top\" align=\"center\">\n" +
                "                                                                                                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\">\n" +
                "                                                                                                            <tbody>\n" +
                "                                                                                                                <tr>\n" +
                "                                                                                                                    <td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 10px 20px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left; word-break: break-word;\" class=\"tblCell\">\n" +
                "                                                                                                                        <div style=\"line-height: 200%; text-align: center;\"><span style=\"font-size: 30px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; line-height: 200%;\"><strong> 野男人网站的验证码  </strong></span>\n" +
                "                                                                                                                            <br>\n" +
                "                                                                                                                            <br><span style=\"font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; line-height: 200%;\"> From Yenanren's website. </span></div>\n" +
                "                                                                                                                    </td>\n" +
                "                                                                                                                </tr>\n" +
                "                                                                                                            </tbody>\n" +
                "                                                                                                        </table>\n" +
                "                                                                                                    </td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </div>\n" +
                "                                                                    <div id=\"dv_13\" class=\"blk_wrapper\">\n" +
                "                                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"tblCellMain\" style=\"padding-top:20px; padding-bottom:20px;padding-left:20px;padding-right:20px;\">\n" +
                "                                                                                        <table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td><span></span></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </div>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                            <tr>\n" +
                "                                                                <td width=\"100%\" class=\"blk_container bmeHolder bmeBody\" name=\"bmeBody\" valign=\"top\" align=\"center\" style=\"color: rgb(56, 56, 56); border: 0px none transparent; background-color: rgb(226, 226, 226);\" bgcolor=\"#e2e2e2\">\n" +
                "                                                                    <div id=\"dv_8\" class=\"blk_wrapper\">\n" +
                "                                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"tblCellMain\" style=\"padding-top:20px; padding-bottom:20px;padding-left:20px;padding-right:20px;\">\n" +
                "                                                                                        <table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td><span></span></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </div>\n" +
                "                                                                    <div id=\"dv_5\" class=\"blk_wrapper\">\n" +
                "                                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_text\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td>\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"bmeContainerRow\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td class=\"tdPart\" valign=\"top\" align=\"center\">\n" +
                "                                                                                                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\">\n" +
                "                                                                                                            <tbody>\n" +
                "                                                                                                                <tr>\n" +
                "                                                                                                                    <td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 10px 20px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left; word-break: break-word;\" class=\"tblCell\">\n" +
                "                                                                                                                        <div style=\"line-height: 200%;\"><span style=\"font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #808080; line-height: 200%;\"><strong>此次的验证码为:&ensp; <span style=\"color:red\">" + code + "</span>,请两分钟之内使用\n" +
                "  <br>&nbsp; &nbsp;如果您错误地收到了此材料，请联系发件人并从所有计算机中删除该材料。<br><br><span class=\"f4dAQIPUm8f6\">&nbsp;</span></strong>\n" +
                "                                                                                                                            </span>\n" +
                "                                                                                                                        </div>\n" +
                "\n" +
                "\n" +
                "                                                                                                                        <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"bmeContainerRow\" style=\"font-family: Arial, Helvetica, sans-serif; font-size: 14px; color: #808080; line-height: 200%\">\n" +
                "                                                                                                                            <tr align=\"center\">\n" +
                "                                                                                                                                <th>订单编码</th>\n" +
                "                                                                                                                                <th>订单行号</th>\n" +
                "                                                                                                                                <th>版本信息</th>\n" +
                "                                                                                                                            </tr>\n" +
                "                                                                                                                            <tr align=\"center\" th:each=\"val:${params.orderList}\">\n" +
                "                                                                                                                                <td th:text=\"${val.orderCode}\"></td>\n" +
                "                                                                                                                                <td th:text=\"${val.orderLine}\"></td>\n" +
                "                                                                                                                                <td th:text=\"${val.releaseId}\"></td>\n" +
                "                                                                                                                            </tr>\n" +
                "                                                                                                                        </table>\n" +
                "\n" +
                "                                                                                                                        <div style=\"line-height: 150%; font-size: 14px;\"><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;    \n" +
                "  &nbsp; &nbsp; &nbsp;&nbsp;</strong></div>\n" +
                "                                                                                                                    </td>\n" +
                "                                                                                                                </tr>\n" +
                "                                                                                                            </tbody>\n" +
                "                                                                                                        </table>\n" +
                "                                                                                                    </td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </div>\n" +
                "\n" +
                "\n" +
                "                                                                    <div id=\"dv_14\" class=\"blk_wrapper\">\n" +
                "                                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_button\" style=\"\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td width=\"20\"></td>\n" +
                "                                                                                    <td align=\"center\">\n" +
                "                                                                                        <table class=\"tblContainer\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td height=\"10\"></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td align=\"right\">\n" +
                "                                                                                                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"bmeButton\" align=\"right\" style=\"border-collapse: separate;\">\n" +
                "                                                                                                            <tbody>\n" +
                "                                                                                                                <tr>\n" +
                "                                                                                                                    <td style=\"border-radius: 5px; border-width: 0px; border-style: none; border-color: transparent; background-color: rgb(142, 128, 128); text-align: center; font-family: Arial, Helvetica, sans-serif; font-size: 14px; padding: 10px 35px; font-weight: bold; font-style: normal;\"\n" +
                "                                                                                                                        class=\"bmeButtonText\"><span style=\"font-family: Arial, Verdana; font-size: 14px; color: rgb(255, 255, 255);\">    \n" +
                "  <a style=\"color:#FFFFFF;text-decoration:none;\" target=\"_blank\" href=\"https://www.yenanren.asia\" draggable=\"false\">Sign in</a></span></td>\n" +
                "                                                                                                                </tr>\n" +
                "                                                                                                            </tbody>\n" +
                "                                                                                                        </table>\n" +
                "                                                                                                    </td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td height=\"10\"></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                    <td width=\"20\"></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "\n" +
                "                                                                        <tr>\n" +
                "                                                                            <td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmeFooter\" valign=\"top\" align=\"left\" style=\"background-color: rgb(226, 226, 226);color: rgb(102, 102, 102); font-size: 10px;  border-style: solid;border-color: rgb(226, 226, 226) rgb(226, 226, 226); border-width: 5px;\"\n" +
                "                                                                                bgcolor=\"\">\n" +
                "\n" +
                "                                                                                <span style=\"font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DC143C; line-height: 200%;\"><strong>Confidentiality Statement:</strong></span><br> The information\n" +
                "                                                                                transmitted by this email is intended only for the person or entity to which it is addressed. This email may contain proprietary, business-confidential and/or privileged material.\n" +
                "                                                                                If you are not the intended recipient of this message, be aware that any use, review, retransmission, distribution, reproduction or any action taken in reliance upon this\n" +
                "                                                                                message is strictly prohibited. If you received this in error, please contact the sender and delete the material from all computers.<br> Privacy Policy | www.yenanren.asia\n" +
                "                                                                                |\n" +
                "                                                                                <a href=\"https://br-bai.github.io/\" target=\"_blank\">Contact us</a>\n" +
                "                                                                            </td>\n" +
                "                                                                        </tr>\n" +
                "\n" +
                "                                                                    </div>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                            <tr>\n" +
                "                                                                <td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmePreFooter\" valign=\"top\" align=\"center\" style=\"color: rgb(56, 56, 56); border: 0px none transparent; background-color: rgb(255, 255, 255);\" bgcolor=\"#ffffff\">\n" +
                "                                                                    <div id=\"dv_2\" class=\"blk_wrapper\">\n" +
                "                                                                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_footer\" style=\"\">\n" +
                "                                                                            <tbody>\n" +
                "\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td name=\"tblCell\" class=\"tblCell\" style=\"padding: 20px; word-break: break-word;\" valign=\"top\" align=\"left\">\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td name=\"bmeBadgeText\" style=\"text-align:center; word-break: break-word;\" align=\"center\"><span id=\"spnFooterText\" style=\"font-family: Arial, Helvetica, sans-serif; font-weight: normal; font-size: 11px; line-height: 140%;\">The message has been sent by yenanren.asia\n" +
                "  <br>Copyright ©2021 yenanren(www.yenanren.asia). All Rights Reserved.<br><strong>This is an automated reply from a system mailbox. Please do not reply to this email.</strong></span>\n" +
                "                                                                                                        <br><span style=\"font-family: Arial, Helvetica, sans-serif; font-weight: normal; font-size: 11px; line-height: 140%;\"><!-- Verified 0:False:33 -->    \n" +
                "      \n" +
                "      </span></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </div>\n" +
                "\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                            <tr>\n" +
                "                                                <td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmeFooter\" valign=\"top\" align=\"center\" style=\"color: rgb(102, 102, 102); border: 0px none transparent;\" bgcolor=\"\"></td>\n" +
                "                                            </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "    <!-- /Test Path -->\n" +
                "\n" +
                "    <img src=\"/c/o?e=DD7459&amp;c=F90A5&amp;t=1&amp;l=1785FC98&amp;email=yC2M4NyWgGJw6k6FPrk9fwSXAE%2FMRK6o&amp;relid=\" alt=\"\" border=\"0\" style=\"display:none;\" height=\"1\" width=\"1\">\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        return s;
    }
}


