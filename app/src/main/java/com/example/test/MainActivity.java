package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;



import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.MapView;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.PathOverlay;
import com.naver.maps.map.util.FusedLocationSource;
import com.naver.maps.map.util.MarkerIcons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{

    double latTo[] = {36.49565008, 36.49830768, 36.48634563, 36.6042964, 36.678481, 36.4670403, 36.6043027, 36.6042964, 36.52193869, 36.52212745, 39.7958126, 36.532154, 36.6017388, 36.50347929, 36.49722377, 36.49550025, 36.49209573, 36.4985667, 36.607957, 36.6041555, 36.6011012, 36.5951494, 36.5964882, 36.5980812, 36.6043027, 36.60338, 36.51785325, 36.50405991, 36.4665568, 36.51103885, 36.53111061, 36.6087055, 36.47961207, 36.47977461, 36.678481, 36.4994679, 36.51223273, 36.5901165, 36.5901165, 36.5952127, 36.57233623, 36.670413, 36.6067169, 36.61048558, 36.49602737, 36.51747494, 36.5155661, 36.51572435, 36.51585041, 36.51620687, 36.51620687, 36.51576548, 36.5331357, 36.5331357, 36.5331357, 36.5331357, 36.5331357, 36.5331357};
    double lonTo[] = {127.2552599, 127.2518564, 127.2541999, 127.2985208, 127.203176, 127.2815402, 127.2985252, 127.2985208, 127.2542829, 127.258847, 124.9200562, 127.365431, 127.3027861, 127.2472495, 127.2723488, 127.2730352, 127.2689838, 127.2715118, 127.2929784, 127.2914281, 127.2732888, 127.3011287, 127.3016755, 127.3026994, 127.2985252, 127.2992706, 127.3194078, 127.3006646, 127.2832752, 127.2357843, 127.2353423, 127.1703317, 127.2571142, 127.2518879, 127.203176, 127.2571317, 127.2457102, 127.3016513, 127.3016513, 127.2844444, 127.2844221, 127.298741, 127.2384226, 127.2320266, 127.2689799, 127.3371391, 127.33722, 127.3342144, 127.3353685, 127.335668, 127.335668, 127.3366008, 127.2454549, 127.2454549, 127.2454549, 127.2454549, 127.2454549, 127.245454};
    String nameTo[] = {"빛가람 근린공원", "품안뜰 근린공원", "가득뜰 근린공원", "세종전통시장 주차타워", "전의왕의물시장(고객지원센터)", "세종대평시장(고객지원센터)", "세종전통시장(고객지원센터)", "세종전통시장(이벤트광장)", "오가낭뜰 근린공원(4동)", "오가낭뜰근린공원(암벽장 옆)", "제천뜰근린공원 화장실", "부강꿈틀 근린공원", "조치원공영터미널", "호수공원 수질정화센터 화장실", "호수공원 수상무대섬 화장실", "호수공원 푸른들판화장실", "호수공원 제1주차장 공중화장실", "호수공원관리센터 공중화장실", "서창리 도시공원화장실4", "참산리 모자이크 화장실", "봉산리 오봉산화장실1", "남리 도시공원화장실3", "남리 도시공원화장실2", "남리 도시공원화장실 1", "세종전통시장 공중화장실", "동물놀이터 화장실", "한나래(강변)", "양화2(강변)", "금남면 체육공원", "고운뜰 근린공원", "밝은뜰 근린공원", "세종시립민속박물관", "한솔뜰 근린공원", "아침뜰 근린공원", "전의생활체육공원", "방축천음악분수", "아름스포츠센터", "조치원체육공원(축구장)", "조치원체육공원(테니스장)", "세종시민체육관", "농어민문화체육센터", "전동시민스포츠센터", "고복자연공원 조각공원", "고복자연공원 연기대첩비", "방울새어린이공원", "합강캠핑장(관리동)", "합강캠핑장(신설A존 화장실)", "합강캠핑장(D존 화장실)", "합강캠핑장(C존 화장실)", "합강캠핑장(B존 장애인화장실)", "합강캠핑장(B존 화장실)", "합강캠핑장(A존 화장실)", "은하수공원 봉안당", "은하수공원 장례식장", "은하수공원 화장장", "은하수공원 3문주차장(야외)", "은하수공원(상징탑 주변 야외)", "은하수공원 고객센터"};

    double latBus601[] = {36.49480415,36.49838339,36.50115762,36.50125372,36.49980116,36.49600659,36.49285179,36.49079532,36.48222217,36.48027258,36.4786841,36.47542611,36.47222212,36.46852933,36.46909014,36.47818732,36.47519374,36.47540352,36.47778779,36.48005163,36.48338698,36.48637325,36.49031649,36.49425872,36.50089782,36.50432413,36.50904125,36.51218874,36.51382171,36.52064159,36.52811794,36.53393415,36.54438337,36.54910746,36.55219899,36.55490236,36.55867449,36.56042834,36.56413695,36.56609618,36.5700677,36.57359533,36.57642687,36.57911861,36.58356586,36.58690458,36.59171876,36.59731184,36.59897376,36.60125263};
    double lonBus601[] = {127.3177789,127.3161172,127.3145621,127.3122171,127.3067592,127.303514,127.3005074,127.2987955,127.2970549,127.2927097,127.2888985,127.2814548,127.2790816,127.2813268,127.2739239,127.2610673,127.2555956,127.2530031,127.2499328,127.2520428,127.2585491,127.2580683,127.2567609,127.2564325,127.2596245,127.2612649,127.2614366,127.2597307,127.2592075,127.2597155,127.2635936,127.2768737,127.2769497,127.278412,127.2781196,127.2773992,127.2783563,127.2804276,127.2835511,127.2849156,127.2878133,127.290342,127.2921403,127.2929749,127.2939846,127.2973605,127.2989039,127.2989163,127.2986064,127.2972429};
    String nameBus601[] = {"수루배마을6단지","수루배마을8,9단지","수루배마을4단지","반곡초,중학교","수루배마을1단지","국책연구단지북측","한국조세제정연구원","글벗중학교(새샘마을9단지)","소담동 새샘마을","세종우체국(보람초등학교)","세종시청.교육청.시의회","보람동(호려울마을)","대평동커뮤니티센터","용포리","세종시외버스터미널","첫마을3단지","한솔중학교(첫마을7단지)","첫마을6단지","첫마을5단지","첫마을4단지","첫마을1단지","새롬동.나성동","새롬동,다정동","다정동 대성고등학교","정부세종청사남측","정부세종청사북측","인사혁신처","도램마을8,10단지","도담동","세종충남대학교병원(후문)","해밀리","한별리","연기리","보통2리","방공학교","실광주유소","대원아파트","대원아파트후문","봉암리","세종교통","세종장례식장입구","월하리(패션아울렛)","월하리(항공학교)","월하리","번암삼거리","범암아파트","죽림리","효성세종병원","조치원전통시장","조치원역"};

    double latBusB5[] = {36.46915891,36.47194252,36.47542002,36.4786841,36.48222217,36.48559453,36.49140197,36.49917853,36.49815435,36.50150614,36.53397446,36.53361885,36.5274859,36.5205448,36.51833472,36.51906543,36.51898731,36.51679381,36.511551,36.50791469,36.50367873,36.49967513,36.49934812,36.49874034,36.49425872,36.48637325,36.4799245,36.47075918,36.46915891};
    double lonBusB5[] = {127.2729444,127.276536,127.2814487,127.2888985,127.2970549,127.3007253,127.3040115,127.310027,127.3226351,127.329932,127.2922685,127.274043,127.2628854,127.2594627,127.257678,127.2482918,127.2444932,127.2414049,127.2412755,127.2411606,127.2408848,127.2427379,127.247321,127.2546038,127.2564325,127.2580683,127.2626882,127.2722923,127.2729444};
    String nameBusB5[] = {"세종시외버스터미널(지상)","대평동","보람동.대평동","세종시청.교육청.시의회","소담동 새샘마을","법원 . 경찰청","국책연구단지","반곡동 / 수루배마을","집현리","산학연클러스터","누리리","한별리","해밀리","세종충남대학교병원(후문)","세종충남대학교병원","범지기마을 10단지 북측","범지기마을 3,9단지","아름 제2중(가락마을20단지)","고운뜰공원,대법원등기정보센터","가락마을8단지,가재마을4단지","종촌초등학교(가락마을6,7단지)","다빛초등학교(가온마을3단지)","가재마을5단지,가온마을6단지","어진중학교,가재마을9단지","다정동 대성고등학교","새롬동.나성동","한솔동","세종시외버스터미널(지하)","세종시외버스터미널(지상)"};

    double latBus991[] = {36.49613892,36.49285179,36.49079532,36.48420546,36.48244859,36.48150586,36.48073453,36.47962037,36.48029529,36.47872046,36.47574211,36.47234579,36.46905647,36.48136181,36.48702874,36.49034943,36.49357358,36.5015209,36.50486239,36.5090337,36.51210563,36.51422413,36.52064159,36.52811794,36.53393415,36.54236466,36.56181354,36.57837868,36.59092485,36.59455662,36.59560852,36.6016996,36.60607187,36.61052334,36.62164103,36.65394362,36.66363405,36.66558263,36.67949754,36.68044259,36.68094375,36.69826728,36.70853509,36.71887393,36.72135952,36.72650155,36.73001914};
    double lonBus991[] = {127.3036599,127.3005074,127.2987955,127.3045807,127.3070589,127.3027687,127.2989847,127.2959602,127.2922829,127.2886722,127.2815707,127.2764544,127.2738163,127.2619359,127.2579388,127.2567397,127.2565531,127.2601638,127.2617227,127.2615994,127.2599559,127.2593357,127.2597155,127.2635936,127.2768737,127.2744281,127.2851407,127.2927196,127.29181,127.2911991,127.2955638,127.2948967,127.2940909,127.2933695,127.2907544,127.2670377,127.2555873,127.2447285,127.20372,127.1968435,127.1819946,127.1523731,127.1530119,127.1567141,127.1576267,127.1617944,127.166863,};
    String nameBus991[] = {"국책연구단지북측","한국조세제정연구원","글벗중학교(새샘마을9단지)","새샘마을6단지","한국개발연구원(KDI)","소담고등학교(새샘마을1단지)","새샘마을1,2단지","호려울마을8,9단지","세종우체국(보람초등학교)","세종시청,교육청,시의회","보람동(호려울마을)","대평동(해들마을)","세종고속시외버스터미널","한솔동 첫마을","새롬동,나성동","새롬동,다정동","다정동,대성고등학교","정부세종청사남측","세종청사북측","인사혁신처","도램마을 8,10단지","도담동(도램마을)","세종충남대학교병원(후문)","해밀리","한별리","연기면사무소","봉암리","월하리","자이아파트","신흥사거리","대동초등학교","조치원역뒤편","세종세무서","고려대학교","홍익대학교","전동삼거리","청송산업단지입구","아람달동림권역체험관","전의역","전의중학교","민석아파트입구","운당1리","KCC앞","소정리역","소정면사무소","소정육교(맹골)","대곡리"};

    double latBusB0[] = {36.47057929,36.47194252,36.47542002,36.4786841,36.48222217,36.48559453,36.49140197,36.49917853,36.49815435,36.50150614,36.53151366,36.53397446,36.53361885,36.5274859,36.5205448,36.51382171,36.50432413,36.50089782,36.49417964,36.48637325,36.4799245,36.47057929};
    double lonBusB0[] = {127.2732839,127.276536,127.2814487,127.2888985,127.2970549,127.3007253,127.3040115,127.310027,127.3226351,127.329932,127.3180268,127.2922685,127.274043,127.2628854,127.2594627,127.2592075,127.2612649,127.2596245,127.2563922,127.2580683,127.2626882,127.2732839};
    String nameBusB0[] = {"세종고속시외버스터미널","대평동","보람동.대평동","세종시청.교육청.시의회","소담동 새샘마을","법원 . 경찰청","국책연구단지","반곡동 / 수루배마을","집현리","산학연클러스터","다솜리","누리리","한별리","해밀리","세종충남대학교병원","도담동","정부세종청사북측","정부세종청사남측","다정동","새롬동.나성동","한솔동","세종고속시외버스터미널"};

    double latPark[]={36.4652194, 36.51518218, 36.6014067, 36.6042964, 36.5281612, 36.5929062, 36.49933013, 36.50497406, 36.51972434, 36.52201898, 36.52201898 ,36.57299943, 36.49452387, 36.49420674, 36.47097935, 36.51550815, 36.55551271, 36.4973079, 36.46414546, 36.5901165, 36.6043027, 36.6055746, 36.5296786, 36.6811573, 36.48522953, 36.50627119, 36.48607004, 36.47929677, 36.47917404, 36.51144395, 36.48053347, 36.47793067, 36.48407359, 36.7223074, 36.51975666, 36.6068458, 36.5123515, 36.5553423, 36.5925261, 36.4967092, 36.6812937, 36.5046345, 36.50270476, 36.47750943, 36.48120553, 36.6004192, 36.51139731, 36.50374844};
    double lonPark[]={127.2822131,127.25971,127.3033967,127.2985208,127.3692664,127.2922529,127.3290131,127.2353641,127.2365898,127.2551499,127.2551499,127.2831882,127.2503429,127.2631198,127.279315,127.2615198,127.271529,127.360943,127.2474375,127.3016513,127.2985252,127.2963827,127.370902,127.1960004,127.2518756,127.2736707,127.2566965,127.292263,127.2546671,127.2466254,127.259172,127.2913572,127.3003683,127.1582811,127.2454788,127.3007553,127.2468897,127.3273282,127.2716426,127.2056167,127.1957672,127.2468694,127.2467871,127.2558409,127.2607528,127.2978332,127.2478657,127.2497076};
    String namePark[]={"금남대평","세종로컬푸드직매장싱싱장터","세종고용복지플러스센터","북세종통합행정복지센터(조치원 읍사무소)","부강 청소년 문화관","세종SB플라자","산학연클러스터 지원센터","고운동 남측 복합커뮤니티센터","고운동 복합커뮤니티센터","오가낭뜰 근린공원 북측","아침뜰 근린공원","세종시 농업기술센터","다정동 복합커뮤니티 센터","세종시 지방자치회관","대평동 복합커뮤니티센터","도담동 복합커뮤니티센터","연서면 하수처리장","연동 부강 하수처리장","수질복원센터","세종시 상하수도 사업소(조치원 하수처리장)","보건환경연구원","세종시 보건소","부강면사무소","전의하수처리장","새롬동 복합커뮤니티센터","세종소방서","새롬종합 복지센터","세종 남부종합재가센터","한솔동 행정복지센터","아름동 119 안전센터","한솔동 119 안전센터","보람동 119 안전센터","소담동 복합커뮤니티센터","소정면사무소","남세종(아름동)종합청소년센터","북세종 종합청소년센터","아름동 복합커뮤니티센터","연동면 복합커뮤니티센터","연서면사무소","장군면사무소","전의면사무소","종촌동 복합커뮤니티센터","종촌종합복지센터","한솔동 복합커뮤니티센터","나성동 노상주차장","조치원주차타워","아름동공영주차장","종촌동공영주차장"};

    double latBusB2[]={36.39164524,36.46915891,36.47075918,36.4799245,36.48637325,36.49417964,36.50089782,36.50432413,36.51382171,36.5205448,36.5274859,36.53361885,36.53397446,36.61921783};
    double lonBusB2[]={127.3150138,127.2729444,127.2722923,127.2626882,127.2580683,127.2563922,127.2596245,127.2612649,127.2592075,127.2594627,127.2628854,127.274043,127.2922685,127.3284594};
    String nameBusB2[]={"금남대평","세종시외버스터미널(지상)","세종시외버스터미널(지하)","한솔동","새롬동,나성동","다정동","정부세종청사남측","정부세종청사북측","도담동","세종충남대학교병원","해밀리","한별리","누리리","오송역"};

    RadioGroup group1,groupBUS;
    RadioButton radioTo,radioPark,radioBus,radioB0,radioB2,radioB5,radio991,radio601;
    private MapView mapView;
    private NaverMap naverMap;
    private FusedLocationSource locationSource;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    PathOverlay path = new PathOverlay();

    List<LatLng> latlngB0 = new ArrayList<>();
    List<LatLng> latlngB2 = new ArrayList<>();
    List<LatLng> latlngB5 = new ArrayList<>();
    List<LatLng> latlng991 = new ArrayList<>();
    List<LatLng> latlng601 = new ArrayList<>();


    List<Marker> markersTo = new ArrayList<>();
    List<Marker> markersPark = new ArrayList<>();
    List<Marker> markersBusB2 = new ArrayList<>();
    List<Marker> markersBusB0 = new ArrayList<>();
    List<Marker> markersBusB5 = new ArrayList<>();
    List<Marker> markersBus991 = new ArrayList<>();
    List<Marker> markersBus601 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group1 = (RadioGroup) findViewById(R.id.Group1);
        groupBUS = (RadioGroup) findViewById(R.id.GroupBUS);
        radioTo = (RadioButton) findViewById(R.id.RadioTo);
        radioPark = (RadioButton) findViewById(R.id.RadioPark);
        radioBus = (RadioButton) findViewById(R.id.RadioBus);
        radioB0 = (RadioButton) findViewById(R.id.RadioB0);
        radioB2 = (RadioButton) findViewById(R.id.RadioB2);
        radioB5 = (RadioButton) findViewById(R.id.RadioB5);
        radio991 = (RadioButton) findViewById(R.id.Radio991);
        radio601 = (RadioButton) findViewById(R.id.Radio601);

        setMarker(latTo,lonTo,nameTo,markersTo);
        setMarker(latPark,lonPark,namePark,markersPark);
        setMarker(latBusB0,lonBusB0,nameBusB0,markersBusB0);
        setMarker(latBusB2,lonBusB2,nameBusB2,markersBusB2);
        setMarker(latBusB5,lonBusB5,nameBusB5,markersBusB5);
        setMarker(latBus991,lonBus991,nameBus991,markersBus991);
        setMarker(latBus601,lonBus601,nameBus601,markersBus601);

        setLine(latBusB0,lonBusB0,latlngB0);
        setLine(latBusB2,lonBusB2,latlngB2);
        setLine(latBusB5,lonBusB5,latlngB5);
        setLine(latBus991,lonBus991,latlng991);
        setLine(latBus601,lonBus601,latlng601);


        radioBus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioBus.isChecked()) {
                    groupBUS.setVisibility(View.VISIBLE);
                } else{
                    groupBUS.setVisibility(View.INVISIBLE);
                    for (Marker marker : markersBus601) {
                        marker.setMap(null);
                    }
                    for (Marker marker : markersBus991) {
                        marker.setMap(null);
                    }
                    for (Marker marker : markersBusB0) {
                        marker.setMap(null);
                    }
                    for (Marker marker : markersBusB2) {
                        marker.setMap(null);
                    }
                    for (Marker marker : markersBusB5) {
                        marker.setMap(null);
                    }
                    path.setMap(null);
                    }
                }
        });


        radioTo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioTo.isChecked()) {
                    for (Marker marker : markersTo) {
                        marker.setIcon(MarkerIcons.RED);
                        marker.setMap(naverMap);
                    }
                } else {
                    for (Marker marker : markersTo) {
                        marker.setMap(null);
                    }
                }
            }
        });

        radioPark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioPark.isChecked()) {
                    for (Marker marker : markersPark) {
                        marker.setIcon(MarkerIcons.GRAY);
                        marker.setMap(naverMap);
                    }
                } else {
                    for (Marker marker : markersPark) {
                        marker.setMap(null);
                    }
                }
            }
        });

        radioB0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioB0.isChecked()) {
                    for (Marker marker : markersBusB0) {
                        marker.setIcon(MarkerIcons.GREEN);
                        marker.setMap(naverMap);
                    }

                    path.setCoords(latlngB0);
                    path.setMap(naverMap);

                } else {
                    for (Marker marker : markersBusB0) {
                        marker.setMap(null);

                    }

                }
            }
        });

        radioB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioB2.isChecked()) {
                    for (Marker marker : markersBusB2) {
                        marker.setIcon(MarkerIcons.GREEN);
                        marker.setMap(naverMap);
                    }

                    path.setCoords(latlngB2);
                    path.setMap(naverMap);
                } else {
                    for (Marker marker : markersBusB2) {
                        marker.setMap(null);

                    }
                }
            }
        });

        radioB5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioB5.isChecked()) {
                    for (Marker marker : markersBusB5) {
                        marker.setIcon(MarkerIcons.GREEN);
                        marker.setMap(naverMap);
                    }

                    path.setCoords(latlngB5);
                    path.setMap(naverMap);

                } else {
                    for (Marker marker : markersBusB5) {
                        marker.setMap(null);

                    }
                }
            }
        });

        radio991.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radio991.isChecked()) {
                    for (Marker marker : markersBus991) {
                        marker.setIcon(MarkerIcons.GREEN);
                        marker.setMap(naverMap);
                    }

                    path.setCoords(latlng991);
                    path.setMap(naverMap);

                } else {
                    for (Marker marker : markersBus991) {
                        marker.setMap(null);
                    }
                }
            }
        });

        radio601.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radio601.isChecked()) {
                    for (Marker marker : markersBus601) {
                        marker.setIcon(MarkerIcons.GREEN);
                        marker.setMap(naverMap);
                    }

                    path.setCoords(latlng601);
                    path.setMap(naverMap);

                } else {
                    for (Marker marker : markersBus601) {
                        marker.setMap(null);
                    }
                }
            }
        });


        //네이버 지도
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

    }


                @Override
    public void onMapReady(@NonNull NaverMap naverMap)
    {
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);
        this.naverMap = naverMap;

        naverMap.setLocationSource(locationSource);
        ActivityCompat.requestPermissions(this,PERMISSIONS,LOCATION_PERMISSION_REQUEST_CODE);

        //배경 지도 선택
        naverMap.setMapType(NaverMap.MapType.Basic);

        //건물 표시
        naverMap.setLayerGroupEnabled(naverMap.LAYER_GROUP_BUILDING, false);

        //위치 및 각도 조정





    }

    @Override
    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions, @NonNull int[] grantResults) {
        if(locationSource.onRequestPermissionsResult(requestCode, permissions,grantResults)) {
            if(!locationSource.isActivated()){
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
                return;
            }else{
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    private void setMarker(double[] lat,double[] lon,String[] name,List<Marker> markers) {
        for (int i = 0; i < lat.length; i++) {
            Marker marker = new Marker();
            marker.setIconPerspectiveEnabled(true);
            marker.setPosition(new LatLng(lat[i], lon[i]));
            marker.setWidth(60);
            marker.setHeight(80);
            marker.setCaptionText(name[i]);
            markers.add(marker);
        }
    }

    private void setLine(double[] lat,double[] lon,List<LatLng> latlng) {
        for (int i = 0; i < lat.length; i++) {

            latlng.add(new LatLng(lat[i], lon[i]));
            path.setColor(Color.GREEN);
        }
    }

}