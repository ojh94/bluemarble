package itschool.bluemarble.model.entity.tile.abs;

import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.construction.Building;
import itschool.bluemarble.model.entity.construction.Hotel;
import itschool.bluemarble.model.entity.construction.Villa;
import itschool.bluemarble.model.entity.construction.abs.Construction;
import itschool.bluemarble.model.enumclass.Color;
import itschool.bluemarble.model.enumclass.ConstructionType;
import lombok.Getter;

@Getter
public class City extends PurchasableTile {
    
    protected Construction construction = null; // 현재 건물
    protected ConstructionType constructionType = null; // 현재 건물

    protected Villa villa;
    protected Building building;
    protected Hotel hotel;
    protected Color color;
    
    // 생성자
    public City(String name) {
        super(name);
    }
    
    // 초기화 블록
    {
        // 색깔 정의
        switch (name) {
            case "타이베이":
            case "베이징":
            case "마닐라":
            case "싱가포르":
            case "카이로":
            case "이스탄불":
                color = Color.PINK;
                break;
            case "아테네":
            case "코펜하겐":
            case "스톡홀름":
            case "베른":
            case "베를린":
            case "오타와":
                color = Color.GREEN;
                break;
            case "부에노스아이레스":
            case "상파울루":
            case "시드니":
            case "하와이":
            case "리스본":
            case "마드리드":
                color = Color.BROWN;
                break;
            case "도쿄":
            case "파리":
            case "로마":
            case "런던":
            case "뉴욕":
                color = Color.NAVY;
                break;
        }

        // 건물 가격 정의 및 객체 생성
        villa = new Villa(color.getVillaPrice());
        building = new Building(color.getBuildingPrice());
        hotel = new Hotel(color.getHotelPrice());

        // 통행료 정의
        switch (name) {
            case "타이베이":
                toll = 2000;
                villa.setToll(10_000);
                building.setToll(90_000);
                hotel.setToll(250_000);
                break;
            case "베이징":
            case "마닐라":
                toll = 4000;
                villa.setToll(20_000);
                building.setToll(180_000);
                hotel.setToll(450_000);
                break;
            case "싱가포르":
            case "카이로":
                toll = 6000;
                villa.setToll(30_000);
                building.setToll(270_000);
                hotel.setToll(550_000);
                break;
            case "이스탄불":
                toll = 8000;
                villa.setToll(40_000);
                building.setToll(300_000);
                hotel.setToll(600_000);
                break;
            case "아테네":
                toll = 10000;
                villa.setToll(50_000);
                building.setToll(450_000);
                hotel.setToll(750_000);
                break;
            case "코펜하겐":
            case "스톡홀름":
                toll = 12000;
                villa.setToll(60_000);
                building.setToll(500_000);
                hotel.setToll(900_000);
                break;
            case "베른":
            case "베를린":
                toll = 14000;
                villa.setToll(70_000);
                building.setToll(500_000);
                hotel.setToll(950_000);
                break;
            case "오타와":
                toll = 16000;
                villa.setToll(80_000);
                building.setToll(550_000);
                hotel.setToll(1_000_000);
                break;
            case "부에노스아이레스":
                toll = 18000;
                villa.setToll(90_000);
                building.setToll(700_000);
                hotel.setToll(1_050_000);
                break;
            case "상파울루":
            case "시드니":
                toll = 20000;
                villa.setToll(100_000);
                building.setToll(750_000);
                hotel.setToll(1_100_000);
                break;
            case "하와이":
            case "리스본":
                toll = 22000;
                villa.setToll(110_000);
                building.setToll(800_000);
                hotel.setToll(1_150_000);
                break;
            case "마드리드":
                toll = 24000;
                villa.setToll(120_000);
                building.setToll(850_000);
                hotel.setToll(1_200_000);
                break;
            case "도쿄":
                toll = 26000;
                villa.setToll(130_000);
                building.setToll(900_000);
                hotel.setToll(1_270_000);
                break;
            case "파리":
            case "로마":
                toll = 28000;
                villa.setToll(150_000);
                building.setToll(1_000_000);
                hotel.setToll(1_400_000);
                break;
            case "런던":
            case "뉴욕":
                toll = 35000;
                villa.setToll(170_000);
                building.setToll(1_100_000);
                hotel.setToll(1_500_000);
                break;
        }
    }

    // 지역명(파라미터)에 따라 땅 구매가 리턴
    // 지역명(파라미터)에 따라 빌라 구매가 리턴
    // 지역명(파라미터)에 따라 빌딩 구매가 리턴
    // 지역명(파라미터)에 따라 호텔 구매가 리턴

    // 지역명(파라미터)에 따라 땅 통행료 리턴
    // 지역명(파라미터)에 따라 빌라 통행료 리턴
    // 지역명(파라미터)에 따라 빌딩 통행료 리턴
    // 지역명(파라미터)에 따라 호텔 통행료 리턴

    // isPurchasable() 메소드 실행 후 리턴값이 false 일 때 실행하는 메소드
    // 1 : 건물 구매 가능 | 2 : 내 땅이지만 이미 건물을 보유중 | 3 : 남의 땅이므로 통행료 지급
    public int isCity(Player player) {
        if(super.owner == player) {
            if(constructionType == null) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

    // isCity() 메소드에서 1이 출력됐을 때 구매 여부 확인 후 실행
    // VILLA 구매
    public int isVillaPrice() {
        return color.getVillaPrice();
    }

    // BUILDING 구매
    public int isBuildingPrice() {
        return color.getBuildingPrice();
    }

    // HOTEL 구매
    public int isHotelPrice() {
        return color.getHotelPrice();
    }


    @Override
    public int getToll() throws Exception {
        if(!isPurchasable()) {
            // ConstructibleTile에서 건물 여부를 체크하고 합산하는 메소드가 필요함

        }
        return 0;
    }

    // 건물을 판다
    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "(");
        sb.append((construction != null)? construction + "有," : "");
        sb.append(GameByConsole.formatWithCommas(price) + ", " + GameByConsole.formatWithCommas(toll) + ")");

        return sb.toString();
    }*/
    //ㅇㅇ
}