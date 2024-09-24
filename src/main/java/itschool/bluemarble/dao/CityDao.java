package itschool.bluemarble.dao;

import itschool.bluemarble.dao.base.CommonDao;
import itschool.bluemarble.model.entity.tile.FixedTollCity;
import itschool.bluemarble.model.entity.tile.SpecialVehicle;
import itschool.bluemarble.model.entity.tile.abs.City;
import itschool.bluemarble.model.enumclass.Color;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends CommonDao {
    public List<City> selectCities() {
        List<City> resultList = new ArrayList<>();

        try(Connection dbConn = connect();
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery("select * from city")) {

            while (rs.next()) {
                //City city = new City("타이베이", Color.PINK,50_000,2_000,10_000,90_000,250_000);
                int index = rs.getInt("index");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int toll = rs.getInt("toll");
                Color color = Color.valueOf(rs.getString("color"));
                int villaToll = rs.getInt("villa_toll");
                int buildingToll = rs.getInt("building_toll");
                int hotelToll = rs.getInt("hotel_toll");
                City city = new City(index,name,color,price,toll,villaToll,buildingToll,hotelToll);
                resultList.add(city);
            }
            return resultList;
        }catch (SQLException e){
            throw new RuntimeException("selectCities 오류 발생\n",e);
        }
    }

    public List<FixedTollCity> selectFixedTollCities() {
        List<FixedTollCity> resultList = new ArrayList<>();
        try(Connection dbConn = connect();
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery("select * from fixed_toll_tile;")) {
            while (rs.next()) {
                int index = rs.getInt("index");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int toll = rs.getInt("toll");
                FixedTollCity fixedTollCity = new FixedTollCity(index,name,price,toll);
                resultList.add(fixedTollCity);
            }


            return resultList;
        }catch (SQLException e){
            throw new RuntimeException("selectCities 오류 발생\n",e);
        }
    }
/*
    public List<SpecialVehicle> selectSpecialTollCities() {
        List<SpecialVehicle> resultList = new ArrayList<>();
        try(Connection dbConn = connect();
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery("select * from fixed_toll_tile")) {
            int index = rs.getInt("index");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int toll = rs.getInt("toll");
            SpecialVehicle specialVehicle = new SpecialVehicle(name,price,toll);
            resultList.add(specialVehicle);

            return resultList;
        }catch (SQLException e){
            throw new RuntimeException("selectCities 오류 발생\n",e);
        }
    }*/

}
