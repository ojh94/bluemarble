package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.tile.abs.PurchasableTile;
import lombok.Getter;

@Getter
public class SpecialVehicle extends FixedTollCity {
    public SpecialVehicle(int index,String name, int price, int toll){
        super(index, name,price,toll);
    }

    void setOwner(Player player){
        this.owner = player;
    }

    {
        // 탈것
        switch (name) {
            case "콩코드여객기":
                toll = 300_000;
                break;
            case "퀸엘리자베스호":
                toll = 250_000;
                break;
            case "컬럼비아호":
                toll = 400_000;
                break;
        }
    }

    @Override
    public int getToll() throws RuntimeException {
        return 0;
    }
}
