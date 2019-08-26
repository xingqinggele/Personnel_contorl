package com.zhhl.personnel_contorl.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collection;
import java.util.List;

/**
 * Created by miao on 2018/11/25.
 */
public class Shangfangrenyuan {
    /**
     * Message : 成功
     * State : 0
     * shangfangrenyuan : [{"isNewRecord":true,"xxzjbh":"2836811234B9DC8AE865A836E0A24FA0","xfrdjxxBh":"a37caf645c794a9493bfa46eb24b741e","xfrdjxxxfxiBh":"9dbb1339b4924c88b99ed7edce94f10e","xfrXm":"秦显章","csrq":"1935-04-02 00:00:00","xfrLxdh":"18744486593","xfrdjxxXbdm":"0","sfzLx":"01","mzdm":"01","xfrGmsfhm":"229001193504024831","xfrxfxxBh":"9dbb1339b4924c88b99ed7edce94f10e","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2205000000003000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"精减下放","sfYy":"信访人因素","xfrxfxxssxtMc":"其他","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"69A91A65903489199DE09F05EDA886FA","xfrdjxxBh":"8248958ea79c4b35bc6d38a316bf4802","xfrdjxxxfxiBh":"0d0927afb29b47c187d11a5918667f93","xfrXm":"贾殿刚","xfrLxdh":"15844880715","sfzLx":"01","xfrGmsfhm":"220722197904143418","xfrxfxxBh":"0d0927afb29b47c187d11a5918667f93","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2207222020005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"安全隐患","sfYy":"工作原因","xfrxfxxssxtMc":"质检","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"E734861E812B798FC834E9DA86BDFC11","xfrdjxxBh":"3c70755fba3f4e2cbb9d80e8617aa029","xfrdjxxxfxiBh":"987b8b7cc83448e8bcc80e14f1e95170","xfrXm":"王福杰","csrq":"1958-07-05 00:00:00","xfrLxdh":"13079710298","xfrdjxxXbdm":"0","hjdzDzmc":"吉林市舒兰市法特镇向公村五社","sfzLx":"01","mzdm":"01","xfrGmsfhm":"220222195807053510","xfrxfxxBh":"987b8b7cc83448e8bcc80e14f1e95170","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2202831000005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"其他","sfYy":"其他","xfrxfxxssxtMc":"农业","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"67276FFD90348919CCB70A3A50275491","xfrdjxxBh":"7b7e969eb3d547c6afc8df7ecd2c538a","xfrdjxxxfxiBh":"952e95a074ca46d5950e27ea08602ecc","xfrXm":"田春鹏","xfrLxdh":"13804400418","xfrdjxxXbdm":"1","sfzLx":"01","xfrGmsfhm":"220821197108255717","xfrxfxxBh":"952e95a074ca46d5950e27ea08602ecc","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省长信访信箱","xfrxfxxwtsdDzmc":"2208210000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"土地承包","sfYy":"信访人因素","rgxksj":"2017-10-01 16:18:53"},{"isNewRecord":true,"xxzjbh":"2E76EF26003D35C426625A9894B92B37","xfrdjxxBh":"9b7702c1351f4f4a865f14c474af5e36","xfrdjxxxfxiBh":"04c9f41ac62c4b1ca3f470d07481d687","xfrXm":"狄守辉","csrq":"1956-11-16 00:00:00","xfrLxdh":"13596449868","xfrdjxxXbdm":"0","hjdzDzmc":"吉林省长春市汽开区","xfrdjxxZylbdm":"06","sfzLx":"01","mzdm":"01","xfrGmsfhm":"22010419561116611X","hjdzXzqhdm":"220106170000","xfrdjxxYzbm":"130000","xfrdjxxtxDzmc":"汽开区日新村","xfrxfxxBh":"04c9f41ac62c4b1ca3f470d07481d687","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2201061700005000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"土地承包","sfYy":"信访人因素","xfrxfxxssxtMc":"农业","rgxksj":"2017-10-01 16:18:55"},{"isNewRecord":true,"xxzjbh":"C7390E8060B85699F667CA186423FC7D","xfrdjxxBh":"b86b2f7b4b4442eb86f211c7ffc90526","xfrdjxxxfxiBh":"6ef0f1d6fe2b49bea4ca2630188da6a0","xfrXm":"何伟光","sfzLx":"01","xfrGmsfhm":"22240419880508283X","xfrxfxxBh":"6ef0f1d6fe2b49bea4ca2630188da6a0","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省长信访信箱","xfrxfxxwtsdDzmc":"2200000000002999011000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"矿产开采","sfYy":"其他","xfrxfxxssxtMc":"煤炭","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"2BBE40DAE039707868BB421D77EBCD4F","xfrdjxxBh":"b6bf0b4cf02c421795825f19b968bd3d","xfrdjxxxfxiBh":"0ca4de54abfe4e09960b2b57dbfcb5ac","xfrXm":"蒲宏","xfrLxdh":"13756151798","sfzLx":"01","xfrGmsfhm":"510225197506083473","xfrxfxxBh":"0ca4de54abfe4e09960b2b57dbfcb5ac","xfrxfxxxfRs":"4","xfrxfxxwtsdDzmc":"2201000000003000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"农民工权益","sfYy":"其他","xfrxfxxssxtMc":"劳动保障","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"71B197A38C28DD4598B1DA99E9AC8376","xfrdjxxBh":"c49bb01f5e2d49ed9205e16339087fb9","xfrdjxxxfxiBh":"979702a740594339813f935fad57c8b9","xfrXm":"咸金花","xfrLxdh":"15004331906","sfzLx":"01","xfrGmsfhm":"222401197504060027","xfrxfxxBh":"979702a740594339813f935fad57c8b9","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2224010000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"水污染","sfYy":"其他","xfrxfxxssxtMc":"环保","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"4BA8C01D90348919C9225D040FAB609E","xfrdjxxBh":"02c18476f6604910996c8de51fe2bc7a","xfrdjxxxfxiBh":"4986b4a43d444150837927a792e5a38f","xfrXm":"王殿成","xfrLxdh":"13943961246","sfzLx":"01","xfrGmsfhm":"220622196310230039","xfrxfxxBh":"4986b4a43d444150837927a792e5a38f","xfrxfxxxfRs":"2","xfrxfxxwtsdDzmc":"2206220000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"林权改革及权属纠纷","sfYy":"其他","xfrxfxxssxtMc":"党委政府","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"8DE17CFD5AEA520F15AB035092FF6957","xfrdjxxBh":"34d35a0c45744de9b23297f5ce16b0c3","xfrdjxxxfxiBh":"65cf979b55d5415fb385709a7b6c0e86","xfrXm":"赵淑波","xfrLxdh":"18304471870","sfzLx":"01","xfrGmsfhm":"22232319680116092x","xfrxfxxBh":"65cf979b55d5415fb385709a7b6c0e86","xfrxfxxxfRs":"3","xfrxfxxwtsdDzmc":"2207221020005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"安置补偿","sfYy":"工作原因","xfrxfxxssxtMc":"国土","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"05289474F434EF34B029720F033E9E04","xfrdjxxBh":"59ad981cc68e426799f85845429d0e97","xfrdjxxxfxiBh":"e745d580c0f74dcdb369a79bc647dd45","xfrXm":"王玉春","sfzLx":"01","xfrGmsfhm":"229001196803154859","xfrxfxxBh":"e745d580c0f74dcdb369a79bc647dd45","xfrxfxxxfRs":"4","xfrxfxxwtsdDzmc":"2207220000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"农民工权益","sfYy":"其他","xfrxfxxssxtMc":"劳动保障","rgxksj":"2017-10-01 16:18:53"},{"isNewRecord":true,"xxzjbh":"102C7E3256F2A25F94361F177E3BDE15","xfrdjxxBh":"aa9177b267174d57b2f0f827e80ee919","xfrdjxxxfxiBh":"6c2ffb2a082e44a4a6b032412715c1ad","xfrXm":"高秀琴","xfrLxdh":"18843927959","sfzLx":"01","xfrGmsfhm":"22060319681115192X","xfrxfxxBh":"6c2ffb2a082e44a4a6b032412715c1ad","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2206050000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"申诉","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"其他","sfYy":"其他","xfrxfxxssxtMc":"交通","rgxksj":"2017-10-01 16:18:56"},{"isNewRecord":true,"xxzjbh":"DB319A52812B798F3CB8C9E2C2288728","xfrdjxxBh":"cd608fd404ed46e789e6e09e5c9308ca","xfrdjxxxfxiBh":"9416b5d24c4c4460b9eba8237d49a46b","xfrXm":"罗守智","xfrLxdh":"13943466488","xfrdjxxXbdm":"0","sfzLx":"01","xfrGmsfhm":"220303194403033013","xfrxfxxBh":"9416b5d24c4c4460b9eba8237d49a46b","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省长信访信箱","xfrxfxxwtsdDzmc":"2203020000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"意见建议","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"作风建设","sfYy":"信访人因素","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"E6768F8222BCCE22E8287722D6758170","xfrdjxxBh":"84ad97bad532406193af7fa813f0ab37","xfrdjxxxfxiBh":"c8808767f01d49a39f391afacc312a47","xfrXm":"高文欣","xfrLxdh":"15043328966","xfrxfxxBh":"c8808767f01d49a39f391afacc312a47","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省信访局","xfrxfxxwtsdDzmc":"2200000000002456000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"企业改制","sfYy":"信访人因素","xfrxfxxssxtMc":"烟草","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"DE2DD9FA0FBA24865730BE63F0218934","xfrdjxxBh":"424c0ec6876e44e2aaa7661ea1319158","xfrdjxxxfxiBh":"e2d9a6a349604206a46cae792b8ecf1b","xfrXm":"管红亮","csrq":"1971-10-13 00:00:00","xfrLxdh":"15944749999","xfrdjxxXbdm":"0","sfzLx":"01","mzdm":"01","xfrGmsfhm":"220422197110130416","xfrxfxxBh":"e2d9a6a349604206a46cae792b8ecf1b","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2212000000003000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"土地规划","sfYy":"信访人因素","xfrxfxxssxtMc":"国土","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"602C912D0FBA2486FC26F92862224BC5","xfrdjxxBh":"21c4cf15460e44dfb54427721e7bbcb2","xfrdjxxxfxiBh":"5e6e5a7f675b4c0cb0f69680f9ca7597","xfrXm":"刁永利","sfzLx":"01","xfrGmsfhm":"220104193811154712","xfrxfxxBh":"5e6e5a7f675b4c0cb0f69680f9ca7597","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2200000000002306000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"其他","sfYy":"其他","xfrxfxxssxtMc":"工商","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"BB2DB4C534B9DC8A1436CC1E402F44AB","xfrdjxxBh":"068ca5f1491446e4bc1ac466fabe206a","xfrdjxxxfxiBh":"9b120a87d9ba4963bf30a530f700f609","xfrXm":"李玉春","xfrxfxxBh":"9b120a87d9ba4963bf30a530f700f609","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2205021000005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"民事诉讼","sfYy":"其他","xfrxfxxssxtMc":"司法","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"282B6D92F434EF3459B61975C6389A4A","xfrdjxxBh":"a830d285c52843ce9e8bf26805606589","xfrdjxxxfxiBh":"914d135693ae4c37b70765fc4bbd3a8d","xfrXm":"王喜奎","sfzLx":"01","xfrGmsfhm":"220402195402011414","xfrxfxxBh":"914d135693ae4c37b70765fc4bbd3a8d","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2204020000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"职工养老保险","sfYy":"其他","xfrxfxxssxtMc":"劳动保障","rgxksj":"2017-10-01 16:18:52"},{"isNewRecord":true,"xxzjbh":"5235697D8FF10B976630935BE330E168","xfrdjxxBh":"d45da9f0a8d24d069d277e3b686fbfbf","xfrdjxxxfxiBh":"8468d7e4dfd94b759095e623f470beaa","xfrXm":"王成彬","xfrLxdh":"13844131724","xfrdjxxXbdm":"0","sfzLx":"01","xfrGmsfhm":"220181197508160619","xfrxfxxBh":"8468d7e4dfd94b759095e623f470beaa","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省长信访信箱","xfrxfxxwtsdDzmc":"2201130000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"其他","sfYy":"信访人因素","rgxksj":"2017-10-01 16:18:55"},{"isNewRecord":true,"xxzjbh":"EE3895E4EE221494F827344E5832AF01","xfrdjxxBh":"000000001455000000000000201121699029","xfrdjxxxfxiBh":"956599c02a2b4fab94c365a2aba2c731","xfrXm":"李占民","csrq":"1963-02-19 00:00:00","xfrLxdh":"15948499500","xfrdjxxXbdm":"0","hjdzDzmc":"吉林省吉林市舒兰市","sfzLx":"01","mzdm":"01","xfrGmsfhm":"220222196302197118","hjdzXzqhdm":"220283000000","xfrdjxxtxdzDm":"通信地址","xfrxfxxBh":"956599c02a2b4fab94c365a2aba2c731","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2202832030005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"产权交易","sfYy":"其他","xfrxfxxssxtMc":"建设","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"CEBE8A5A887D5F81B46ABF0332616F02","xfrdjxxBh":"ce9b49b207124053b8f1728c280a1cef","xfrdjxxxfxiBh":"bcb4260dc7e245308fc8d9f53920b9a7","xfrXm":"张玉顺","csrq":"1971-12-16 00:00:00","xfrLxdh":"18843943533","xfrdjxxXbdm":"0","sfzLx":"01","mzdm":"01","xfrGmsfhm":"220603197112163213","xfrxfxxBh":"bcb4260dc7e245308fc8d9f53920b9a7","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2206050000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"其他","sfYy":"其他","xfrxfxxssxtMc":"农业","rgxksj":"2017-10-01 16:18:55"},{"isNewRecord":true,"xxzjbh":"B038202F0FBA24868DE5973F08A02CC6","xfrdjxxBh":"b62c6888c96747d790cc315563faf1a7","xfrdjxxxfxiBh":"764e2cb07cd041ab822412345e380aaa","xfrXm":"吴小满","xfrLxdh":"13321410377","sfzLx":"01","xfrGmsfhm":"220104197805212611","xfrxfxxBh":"764e2cb07cd041ab822412345e380aaa","xfrxfxxxfRs":"4","xfrxfxxwtsdDzmc":"2200000000002432000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"其他","sfYy":"其他","xfrxfxxssxtMc":"建设","rgxksj":"2017-10-01 16:18:52"},{"isNewRecord":true,"xxzjbh":"743C1E69F434EF34823B1F3F5EA4A1D7","xfrdjxxBh":"3d8a1e7dd0744d2785ad393662a818e9","xfrdjxxxfxiBh":"76ffa0c3dcb948ada1ee51cf4ccd0a84","xfrXm":"阚兴玉","xfrLxdh":"15590116740","sfzLx":"01","xfrGmsfhm":"222323193509236313","xfrxfxxBh":"76ffa0c3dcb948ada1ee51cf4ccd0a84","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2207224050005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"林权改革及权属纠纷","sfYy":"工作原因","xfrxfxxssxtMc":"农业","rgxksj":"2017-10-01 16:18:53"},{"isNewRecord":true,"xxzjbh":"1FB6C64E4039164FC6B4A6D258A261D1","xfrdjxxBh":"dbb888dbbf014af28de92466efe56698","xfrdjxxxfxiBh":"45acd6e56c314f93addeb5ffb383c53c","xfrXm":"兰海君","csrq":"1965-01-15 00:00:00","xfrLxdh":"15044588952","xfrdjxxXbdm":"0","sfzLx":"01","mzdm":"01","xfrGmsfhm":"22050319650115103X","xfrxfxxBh":"45acd6e56c314f93addeb5ffb383c53c","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2205030000004455000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"农村低保","sfYy":"信访人因素","xfrxfxxssxtMc":"民政","rgxksj":"2017-10-01 16:18:53"},{"isNewRecord":true,"xxzjbh":"E2350AB29034891944EF65ED1630F770","xfrdjxxBh":"cbb9885bfe7c4e2aaa1535e68f088f19","xfrdjxxxfxiBh":"f4578856a39a4938bcee447b08038809","xfrXm":"田春鹏","xfrLxdh":"13804400418","xfrdjxxXbdm":"1","sfzLx":"01","xfrGmsfhm":"220821197108255717","xfrxfxxBh":"f4578856a39a4938bcee447b08038809","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省委书记信访信箱","xfrxfxxwtsdDzmc":"2208210000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"意见建议","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"土地承包","sfYy":"信访人因素","xfrxfxxssxtMc":"其他","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"6562DBC7812B798F113F8B1058A313D3","xfrdjxxBh":"635d9cd7160947e1a15bea7f4a9b63b5","xfrdjxxxfxiBh":"62484d03ff544986bc64938c943e6a30","xfrXm":"邵芝华","xfrxfxxBh":"62484d03ff544986bc64938c943e6a30","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2205021000005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"民事诉讼","sfYy":"其他","xfrxfxxssxtMc":"司法","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"46B6CFDD003D35C49B2758AD743D5CB3","xfrdjxxBh":"b54b08a2014946babd07a5027f66d0e4","xfrdjxxxfxiBh":"3ba784b9b0344f7d80128e6d0a72a410","xfrXm":"刘新敏","xfrLxdh":"13943968307","sfzLx":"01","xfrGmsfhm":"220622196603090025","xfrxfxxBh":"3ba784b9b0344f7d80128e6d0a72a410","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2206220000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"退休人员待遇","sfYy":"其他","xfrxfxxssxtMc":"其他","rgxksj":"2017-10-01 16:18:55"},{"isNewRecord":true,"xxzjbh":"FB7D63E2EE221494F0A7F8FC93F038CF","xfrdjxxBh":"31f5411cfd8a4c4d9423b8c5e898ffb7","xfrdjxxxfxiBh":"58715185d1314c28833540dbad97843b","xfrXm":"齐铁民","xfrxfxxBh":"58715185d1314c28833540dbad97843b","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2205021000005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"民事诉讼","sfYy":"其他","xfrxfxxssxtMc":"司法","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"A42855FD812B798F77F0FC5FB028988D","xfrdjxxBh":"68340e394c96419781b2b19ff66475e9","xfrdjxxxfxiBh":"63cfc579908f4ec383d928d2d4a38c14","xfrXm":" 徐正宁","xfrLxdh":"13804191510","sfzLx":"01","xfrGmsfhm":"21102219901282016","xfrxfxxBh":"63cfc579908f4ec383d928d2d4a38c14","xfrxfxxxfRs":"20","xfrxfxxwtsdDzmc":"2201050030005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"民事诉讼","sfYy":"其他","xfrxfxxssxtMc":"法院","rgxksj":"2017-10-01 16:18:55"},{"isNewRecord":true,"xxzjbh":"63A0D1BD22BCCE2298B38CDB68A089F7","xfrdjxxBh":"d7836dfa23ca4842af23a573e5ea7efb","xfrdjxxxfxiBh":"8944417cd5e040a590d551356c99e5de","xfrXm":"车钟珠","xfrLxdh":"13943372167","sfzLx":"01","xfrGmsfhm":"222401196211200319","xfrxfxxBh":"8944417cd5e040a590d551356c99e5de","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2224010020005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"福利待遇","sfYy":"其他","xfrxfxxssxtMc":"其他","rgxksj":"2017-10-01 16:18:52"},{"isNewRecord":true,"xxzjbh":"4CBAC6D7B8B097C5C0E2CAF80EE9077E","xfrdjxxBh":"cbd1fe5e6fa546ffb57af1823ab3573f","xfrdjxxxfxiBh":"5302b04ae8ab492cb92959a0438d571e","xfrXm":"王国祥","xfrLxdh":"13179261805","sfzLx":"01","xfrGmsfhm":"220222193008160775","xfrxfxxBh":"5302b04ae8ab492cb92959a0438d571e","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2202830000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"职工养老保险","sfYy":"政策法规","xfrxfxxssxtMc":"劳动保障","rgxksj":"2017-10-01 16:18:52"},{"isNewRecord":true,"xxzjbh":"7E2F00ED003D35C4F234A5BCCD233E88","xfrdjxxBh":"220000002455000000000000201118273983","xfrdjxxxfxiBh":"220000002455000000000000201118273983","xfrXm":"杨颖峰","csrq":"1940-09-05 00:00:00","xfrdjxxXbdm":"1","hjdzDzmc":"吉林省长春市","sfzLx":"01","xfrGmsfhm":"220104400905332","hjdzXzqhdm":"220100000000","xfrdjxxtxdzDm":"通信地址","xfrxfxxBh":"220000002455000000000000201118273983","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2201040000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"回迁房","sfYy":"其他","xfrxfxxssxtMc":"建设","xfrxfxxrdwtMs":"城镇房屋拆迁","rgxksj":"2017-10-01 16:18:55"},{"isNewRecord":true,"xxzjbh":"8E39BA3DC56F15C0F6F6BE24522E814D","xfrdjxxBh":"acb8be1b3f124c3f8a14d30c1a2df2c1","xfrdjxxxfxiBh":"4e021ffe76c94f49abe2a89b3e657904","xfrXm":"徐忠良","xfrxfxxBh":"4e021ffe76c94f49abe2a89b3e657904","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2205021000005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"民事诉讼","sfYy":"其他","xfrxfxxssxtMc":"司法","rgxksj":"2017-10-01 16:18:52"},{"isNewRecord":true,"xxzjbh":"9464D25398F408C5DE294E841AB86A70","xfrdjxxBh":"40279bee826e44a88ff5301e955afa61","xfrdjxxxfxiBh":"ca24581b95684b0390cb9b23965c6955","xfrXm":"郭殿君","sfzLx":"01","xfrGmsfhm":"22232319490401001X","xfrxfxxBh":"ca24581b95684b0390cb9b23965c6955","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2207220000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"其他","sfYy":"其他","xfrxfxxssxtMc":"农业","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"623A5F256263C307CA3837F414739D94","xfrdjxxBh":"27698dd6daa64af1aef50d93ea5e976e","xfrdjxxxfxiBh":"026861213df945f8b5131ed5c59093a3","xfrXm":"周军","xfrxfxxBh":"026861213df945f8b5131ed5c59093a3","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2205021000005434000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"民事诉讼","sfYy":"其他","xfrxfxxssxtMc":"司法","rgxksj":"2017-10-01 16:18:53"},{"isNewRecord":true,"xxzjbh":"B72F429B0FBA2486943B4157662A3CA1","xfrdjxxBh":"993268d684924a0796c6aab3504b21f1","xfrdjxxxfxiBh":"220800003455000000000000201518657342","xfrXm":"王文国","xfrLxdh":"15704095922","xfrdjxxXbdm":"0","sfzLx":"01","xfrGmsfhm":"222304196103131110","xfrxfxxBh":"220800003455000000000000201518657342","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省委书记信访信箱","xfrxfxxwtsdDzmc":"2208820000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"土地规划","sfYy":"信访人因素","xfrxfxxssxtMc":"国土","xfrxfxxrdwtMs":"农村土地征用","rgxksj":"2017-10-01 16:18:52"},{"isNewRecord":true,"xxzjbh":"88FFB1FDE0397078BE3E3A8760302AEB","xfrdjxxBh":"48760b8fb0284e3d9937e31afc5ec462","xfrdjxxxfxiBh":"220100003455000000000000201418622325","xfrXm":"许桂霞","csrq":"1960-11-22 00:00:00","xfrLxdh":"15843021686","xfrdjxxXbdm":"1","xfrdjxxZylbdm":"15","sfzLx":"01","mzdm":"01","xfrGmsfhm":"22010319601122066X","xfrxfxxBh":"220100003455000000000000201418622325","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2201030000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"职称评定","sfYy":"政策法规","xfrxfxxssxtMc":"组织人事","rgxksj":"2017-10-01 16:18:51"},{"isNewRecord":true,"xxzjbh":"FF2CA706903489195376C0C5243747E4","xfrdjxxBh":"0c5f3fa303434fd181947867971d7cc2","xfrdjxxxfxiBh":"7e58179e4b6545f8a4f81492c338a417","xfrXm":"张志忠","xfrLxdh":"15044133151","xfrdjxxXbdm":"0","sfzLx":"01","mzdm":"01","xfrGmsfhm":"220103195910114137","xfrxfxxBh":"7e58179e4b6545f8a4f81492c338a417","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2201030000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"土地权属纠纷","sfYy":"其他","xfrxfxxssxtMc":"国土","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"B6E515A7903489199EB022B534B4A8B2","xfrdjxxBh":"3c44e7cbdafb4230ade50de68979a58b","xfrdjxxxfxiBh":"ff872f0a2b714316a9b6a82853e34146","xfrXm":"隋洪美","xfrLxdh":"18243929987","sfzLx":"01","xfrGmsfhm":"220603196406180032","xfrxfxxBh":"ff872f0a2b714316a9b6a82853e34146","xfrxfxxxfRs":"3","xfrxfxxwtsdDzmc":"2206050000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"退休人员待遇","sfYy":"信访人因素","xfrxfxxssxtMc":"交通","rgxksj":"2017-10-01 16:18:54"},{"isNewRecord":true,"xxzjbh":"222C5FCC903489194C3E5DA360347AFB","xfrdjxxBh":"91f8a616410c4a48b84752fb3d51d631","xfrdjxxxfxiBh":"e14cae38f09f4f67b158ba967c0bacfc","xfrXm":"杨树春","xfrLxdh":"15584231132","sfzLx":"01","xfrGmsfhm":"220104195402086113","xfrxfxxBh":"e14cae38f09f4f67b158ba967c0bacfc","xfrxfxxxfRs":"2","xfrxfxxwtsdDzmc":"2201061700005000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"粮食直补","sfYy":"其他","xfrxfxxssxtMc":"农业","rgxksj":"2017-10-01 16:18:55"},{"isNewRecord":true,"xxzjbh":"7138498F0FBA24863A3BABD4D17CD9CC","xfrdjxxBh":"9c06771c596e467095d396e85cf92b59","xfrdjxxxfxiBh":"220800003455000000000000201518657342","xfrXm":"李文福","csrq":"1961-05-13 00:00:00","xfrLxdh":"15943633382","xfrdjxxXbdm":"0","sfzLx":"01","xfrGmsfhm":"222304196105131114","xfrxfxxBh":"220800003455000000000000201518657342","xfrxfxxxfRs":"1","xfrxfxxsxrXm":"省长信访信箱","xfrxfxxwtsdDzmc":"2208820000004000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"土地规划","sfYy":"信访人因素","xfrxfxxssxtMc":"国土","xfrxfxxrdwtMs":"农村土地征用","rgxksj":"2017-10-01 16:18:52"},{"isNewRecord":true,"xxzjbh":"E678F7E0EE2214944D3970071A33DEC4","xfrdjxxBh":"3eba998f61aa4888b05bb0c8c9d5e870","xfrdjxxxfxiBh":"7e1b2766364445579fc7ff93b1997dfc","xfrXm":"高玉成","xfrLxdh":"15843688333","sfzLx":"01","xfrGmsfhm":"222301195606302117","xfrxfxxBh":"7e1b2766364445579fc7ff93b1997dfc","xfrxfxxxfRs":"1","xfrxfxxwtsdDzmc":"2208000000003000000000000000","djsj":"2016-12-09 00:00:00","xfsyJyqk":"求决","xfrxfxxxflyMs":"信访人直接提出","xfrxfxxnrFl":"房屋拆迁","sfYy":"其他","xfrxfxxssxtMc":"建设","rgxksj":"2017-10-01 16:18:52"}]
     */

    private String Message;
    private String State;
    private List<ShangfangrenyuanBean> shangfangrenyuan;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public Collection<? extends ShangfangrenyuanBean> getShangfangrenyuan() {
        return shangfangrenyuan;
    }

    public void setShangfangrenyuan(List<ShangfangrenyuanBean> shangfangrenyuan) {
        this.shangfangrenyuan = shangfangrenyuan;
    }

    public static class ShangfangrenyuanBean implements Parcelable {
        /**
         * isNewRecord : true
         * xxzjbh : 2836811234B9DC8AE865A836E0A24FA0
         * xfrdjxxBh : a37caf645c794a9493bfa46eb24b741e
         * xfrdjxxxfxiBh : 9dbb1339b4924c88b99ed7edce94f10e
         * xfrXm : 秦显章
         * csrq : 1935-04-02 00:00:00
         * xfrLxdh : 18744486593
         * xfrdjxxXbdm : 0
         * sfzLx : 01
         * mzdm : 01
         * xfrGmsfhm : 229001193504024831
         * xfrxfxxBh : 9dbb1339b4924c88b99ed7edce94f10e
         * xfrxfxxxfRs : 1
         * xfrxfxxwtsdDzmc : 2205000000003000000000000000
         * djsj : 2016-12-09 00:00:00
         * xfsyJyqk : 求决
         * xfrxfxxxflyMs : 信访人直接提出
         * xfrxfxxnrFl : 精减下放
         * sfYy : 信访人因素
         * xfrxfxxssxtMc : 其他
         * rgxksj : 2017-10-01 16:18:54
         * hjdzDzmc : 吉林市舒兰市法特镇向公村五社
         * xfrxfxxsxrXm : 省长信访信箱
         * xfrdjxxZylbdm : 06
         * hjdzXzqhdm : 220106170000
         * xfrdjxxYzbm : 130000
         * xfrdjxxtxDzmc : 汽开区日新村
         * xfrdjxxtxdzDm : 通信地址
         * xfrxfxxrdwtMs : 城镇房屋拆迁
         */

        private boolean isNewRecord;
        private String xxzjbh;
        private String xfrdjxxBh;
        private String xfrdjxxxfxiBh;
        private String xfrXm;
        private String csrq;
        private String xfrLxdh;
        private String xfrdjxxXbdm;
        private String sfzLx;
        private String mzdm;
        private String xfrGmsfhm;
        private String xfrxfxxBh;
        private String xfrxfxxxfRs;
        private String xfrxfxxwtsdDzmc;
        private String djsj;
        private String xfsyJyqk;
        private String xfrxfxxxflyMs;
        private String xfrxfxxnrFl;
        private String sfYy;
        private String xfrxfxxssxtMc;
        private String rgxksj;
        private String hjdzDzmc;
        private String xfrxfxxsxrXm;
        private String xfrdjxxZylbdm;
        private String hjdzXzqhdm;
        private String xfrdjxxYzbm;
        private String xfrdjxxtxDzmc;
        private String xfrdjxxtxdzDm;
        private String xfrxfxxrdwtMs;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getXxzjbh() {
            return xxzjbh;
        }

        public void setXxzjbh(String xxzjbh) {
            this.xxzjbh = xxzjbh;
        }

        public String getXfrdjxxBh() {
            return xfrdjxxBh;
        }

        public void setXfrdjxxBh(String xfrdjxxBh) {
            this.xfrdjxxBh = xfrdjxxBh;
        }

        public String getXfrdjxxxfxiBh() {
            return xfrdjxxxfxiBh;
        }

        public void setXfrdjxxxfxiBh(String xfrdjxxxfxiBh) {
            this.xfrdjxxxfxiBh = xfrdjxxxfxiBh;
        }

        public String getXfrXm() {
            return xfrXm;
        }

        public void setXfrXm(String xfrXm) {
            this.xfrXm = xfrXm;
        }

        public String getCsrq() {
            return csrq;
        }

        public void setCsrq(String csrq) {
            this.csrq = csrq;
        }

        public String getXfrLxdh() {
            return xfrLxdh;
        }

        public void setXfrLxdh(String xfrLxdh) {
            this.xfrLxdh = xfrLxdh;
        }

        public String getXfrdjxxXbdm() {
            return xfrdjxxXbdm;
        }

        public void setXfrdjxxXbdm(String xfrdjxxXbdm) {
            this.xfrdjxxXbdm = xfrdjxxXbdm;
        }

        public String getSfzLx() {
            return sfzLx;
        }

        public void setSfzLx(String sfzLx) {
            this.sfzLx = sfzLx;
        }

        public String getMzdm() {
            return mzdm;
        }

        public void setMzdm(String mzdm) {
            this.mzdm = mzdm;
        }

        public String getXfrGmsfhm() {
            return xfrGmsfhm;
        }

        public void setXfrGmsfhm(String xfrGmsfhm) {
            this.xfrGmsfhm = xfrGmsfhm;
        }

        public String getXfrxfxxBh() {
            return xfrxfxxBh;
        }

        public void setXfrxfxxBh(String xfrxfxxBh) {
            this.xfrxfxxBh = xfrxfxxBh;
        }

        public String getXfrxfxxxfRs() {
            return xfrxfxxxfRs;
        }

        public void setXfrxfxxxfRs(String xfrxfxxxfRs) {
            this.xfrxfxxxfRs = xfrxfxxxfRs;
        }

        public String getXfrxfxxwtsdDzmc() {
            return xfrxfxxwtsdDzmc;
        }

        public void setXfrxfxxwtsdDzmc(String xfrxfxxwtsdDzmc) {
            this.xfrxfxxwtsdDzmc = xfrxfxxwtsdDzmc;
        }

        public String getDjsj() {
            return djsj;
        }

        public void setDjsj(String djsj) {
            this.djsj = djsj;
        }

        public String getXfsyJyqk() {
            return xfsyJyqk;
        }

        public void setXfsyJyqk(String xfsyJyqk) {
            this.xfsyJyqk = xfsyJyqk;
        }

        public String getXfrxfxxxflyMs() {
            return xfrxfxxxflyMs;
        }

        public void setXfrxfxxxflyMs(String xfrxfxxxflyMs) {
            this.xfrxfxxxflyMs = xfrxfxxxflyMs;
        }

        public String getXfrxfxxnrFl() {
            return xfrxfxxnrFl;
        }

        public void setXfrxfxxnrFl(String xfrxfxxnrFl) {
            this.xfrxfxxnrFl = xfrxfxxnrFl;
        }

        public String getSfYy() {
            return sfYy;
        }

        public void setSfYy(String sfYy) {
            this.sfYy = sfYy;
        }

        public String getXfrxfxxssxtMc() {
            return xfrxfxxssxtMc;
        }

        public void setXfrxfxxssxtMc(String xfrxfxxssxtMc) {
            this.xfrxfxxssxtMc = xfrxfxxssxtMc;
        }

        public String getRgxksj() {
            return rgxksj;
        }

        public void setRgxksj(String rgxksj) {
            this.rgxksj = rgxksj;
        }

        public String getHjdzDzmc() {
            return hjdzDzmc;
        }

        public void setHjdzDzmc(String hjdzDzmc) {
            this.hjdzDzmc = hjdzDzmc;
        }

        public String getXfrxfxxsxrXm() {
            return xfrxfxxsxrXm;
        }

        public void setXfrxfxxsxrXm(String xfrxfxxsxrXm) {
            this.xfrxfxxsxrXm = xfrxfxxsxrXm;
        }

        public String getXfrdjxxZylbdm() {
            return xfrdjxxZylbdm;
        }

        public void setXfrdjxxZylbdm(String xfrdjxxZylbdm) {
            this.xfrdjxxZylbdm = xfrdjxxZylbdm;
        }

        public String getHjdzXzqhdm() {
            return hjdzXzqhdm;
        }

        public void setHjdzXzqhdm(String hjdzXzqhdm) {
            this.hjdzXzqhdm = hjdzXzqhdm;
        }

        public String getXfrdjxxYzbm() {
            return xfrdjxxYzbm;
        }

        public void setXfrdjxxYzbm(String xfrdjxxYzbm) {
            this.xfrdjxxYzbm = xfrdjxxYzbm;
        }

        public String getXfrdjxxtxDzmc() {
            return xfrdjxxtxDzmc;
        }

        public void setXfrdjxxtxDzmc(String xfrdjxxtxDzmc) {
            this.xfrdjxxtxDzmc = xfrdjxxtxDzmc;
        }

        public String getXfrdjxxtxdzDm() {
            return xfrdjxxtxdzDm;
        }

        public void setXfrdjxxtxdzDm(String xfrdjxxtxdzDm) {
            this.xfrdjxxtxdzDm = xfrdjxxtxdzDm;
        }

        public String getXfrxfxxrdwtMs() {
            return xfrxfxxrdwtMs;
        }

        public void setXfrxfxxrdwtMs(String xfrxfxxrdwtMs) {
            this.xfrxfxxrdwtMs = xfrxfxxrdwtMs;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
            dest.writeString(this.xxzjbh);
            dest.writeString(this.xfrdjxxBh);
            dest.writeString(this.xfrdjxxxfxiBh);
            dest.writeString(this.xfrXm);
            dest.writeString(this.csrq);
            dest.writeString(this.xfrLxdh);
            dest.writeString(this.xfrdjxxXbdm);
            dest.writeString(this.sfzLx);
            dest.writeString(this.mzdm);
            dest.writeString(this.xfrGmsfhm);
            dest.writeString(this.xfrxfxxBh);
            dest.writeString(this.xfrxfxxxfRs);
            dest.writeString(this.xfrxfxxwtsdDzmc);
            dest.writeString(this.djsj);
            dest.writeString(this.xfsyJyqk);
            dest.writeString(this.xfrxfxxxflyMs);
            dest.writeString(this.xfrxfxxnrFl);
            dest.writeString(this.sfYy);
            dest.writeString(this.xfrxfxxssxtMc);
            dest.writeString(this.rgxksj);
            dest.writeString(this.hjdzDzmc);
            dest.writeString(this.xfrxfxxsxrXm);
            dest.writeString(this.xfrdjxxZylbdm);
            dest.writeString(this.hjdzXzqhdm);
            dest.writeString(this.xfrdjxxYzbm);
            dest.writeString(this.xfrdjxxtxDzmc);
            dest.writeString(this.xfrdjxxtxdzDm);
            dest.writeString(this.xfrxfxxrdwtMs);
        }

        public ShangfangrenyuanBean() {
        }

        ShangfangrenyuanBean(Parcel in) {
            this.isNewRecord = in.readByte() != 0;
            this.xxzjbh = in.readString();
            this.xfrdjxxBh = in.readString();
            this.xfrdjxxxfxiBh = in.readString();
            this.xfrXm = in.readString();
            this.csrq = in.readString();
            this.xfrLxdh = in.readString();
            this.xfrdjxxXbdm = in.readString();
            this.sfzLx = in.readString();
            this.mzdm = in.readString();
            this.xfrGmsfhm = in.readString();
            this.xfrxfxxBh = in.readString();
            this.xfrxfxxxfRs = in.readString();
            this.xfrxfxxwtsdDzmc = in.readString();
            this.djsj = in.readString();
            this.xfsyJyqk = in.readString();
            this.xfrxfxxxflyMs = in.readString();
            this.xfrxfxxnrFl = in.readString();
            this.sfYy = in.readString();
            this.xfrxfxxssxtMc = in.readString();
            this.rgxksj = in.readString();
            this.hjdzDzmc = in.readString();
            this.xfrxfxxsxrXm = in.readString();
            this.xfrdjxxZylbdm = in.readString();
            this.hjdzXzqhdm = in.readString();
            this.xfrdjxxYzbm = in.readString();
            this.xfrdjxxtxDzmc = in.readString();
            this.xfrdjxxtxdzDm = in.readString();
            this.xfrxfxxrdwtMs = in.readString();
        }

        public static final Creator<ShangfangrenyuanBean> CREATOR = new Creator<ShangfangrenyuanBean>() {
            @Override
            public ShangfangrenyuanBean createFromParcel(Parcel source) {
                return new ShangfangrenyuanBean(source);
            }

            @Override
            public ShangfangrenyuanBean[] newArray(int size) {
                return new ShangfangrenyuanBean[size];
            }
        };
    }
}
