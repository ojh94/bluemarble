package itschool.bluemarble.factory;

import itschool.bluemarble.entity.City;
import itschool.bluemarble.entity.Tile;
import itschool.bluemarble.enumclass.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TileFactory {
    private static ArrayList<Tile> TILES = new ArrayList<Tile>();
    private static GoldenKeys goldenKeys = GoldenKeys.getInstance();

    static {
        TILES.addAll(Arrays.asList(
                new City("시작"), // index 0, Special
                new City("타이베이", Color.PINK,50000,new int[]{2000,10000,90000,250000}), // index 1
                goldenKeys, // index 2
                new City("베이징",Color.PINK,80000,new int[]{4000,20000,180000,450000}), // index 3
                new City("마닐라",Color.PINK,80000,new int[]{4000,20000,180000,450000}), // index 4
                new City("제주도"), // index 5
                new City("싱가포르",Color.PINK,100000,new int[]{6000,30000,270000,550000}), // index 6
                goldenKeys, // index 7
                new City("카이로",Color.PINK,100000,new int[]{6000,30000,270000,550000}), // index 8
                new City("이스탄불",Color.PINK,120000,new int[]{8000,40000,300000,600000}), // index 9
                new City("무인도"), // index 10, Special

                new City("아테네",Color.GREEN,140000,new int[]{10000,50000,450000,750000}), // index 11
                goldenKeys, // index 12
                new City("코펜하겐",Color.GREEN,160000,new int[]{12000,60000,500000,900000}), // index 13
                new City("스톡홀름",Color.GREEN,160000,new int[]{12000,60000,500000,900000}), // index 14
                new City("콩코드여객기"), // index 15, Vehicle
                new City("베른",Color.GREEN,180000,new int[]{14000,70000,500000,950000}), // 전 취리히 // index 16
                goldenKeys, // index 17
                new City("베를린",Color.GREEN,180000,new int[]{14000,70000,500000,950000}), // index 18
                new City("오타와",Color.GREEN,200000,new int[]{16000,80000,550000,1000000}), // 전 몬트리올 // index 19

                new City("사회복지기금접수"), // index 20, Special
                new City("부에노스아이레스",Color.BROWN,220000,new int[]{18000,90000,700000,1050000}), // index 21
                goldenKeys, // index 22
                new City("상파울루",Color.BROWN,240000,new int[]{20000,100000,750000,1100000}), // index 23
                new City("시드니",Color.BROWN,240000,new int[]{20000,100000,750000,1100000}), // index 24
                new City("부산"), // index 25
                new City("하와이",Color.BROWN,260000,new int[]{22000,110000,800000,1150000}), // index 26
                new City("리스본",Color.BROWN,260000,new int[]{22000,110000,800000,1150000}), // index 27
                new City("퀸엘리자베스호"), // index 28, Vehicle
                new City("마드리드",Color.BROWN,280000,new int[]{24000,120000,850000,1200000}), // index 29

                new City("우주여행"), // index 30
                new City("도쿄",Color.NAVY,300000,new int[]{26000,130000,900000,1270000}), // index 31
                new City("컬럼비아호"), // index 32, Vehicle
                new City("파리",Color.NAVY,320000,new int[]{28000,150000,1000000,1400000}), // index 33
                new City("로마",Color.NAVY,320000,new int[]{28000,150000,1000000,1400000}), // index 34
                goldenKeys, // index 35
                new City("런던",Color.NAVY,350000,new int[]{35000,170000,1100000,1500000}), // index 36
                new City("뉴욕",Color.NAVY,350000,new int[]{35000,170000,1100000,1500000}), // index 37
                new City("사회복지기금수령"), // index 38, Special
                new City("서울") // index 39
        ));
    }

    public static ArrayList<Tile> getTiles() {
        return TILES;
    }
}
