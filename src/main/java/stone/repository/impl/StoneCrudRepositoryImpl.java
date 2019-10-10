package stone.repository.impl;

import stone.domain.Gemstone;
import stone.domain.SemipreciouStone;
import stone.domain.Stone;
import stone.enums.Color;
import stone.enums.Transparency;
import org.springframework.stereotype.Repository;
import stone.repository.contract.StoneCrudRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static stone.enums.GemstoneType.*;
import static stone.enums.SemipreciouStoneType.*;


@Repository
public class StoneCrudRepositoryImpl implements StoneCrudRepository {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<Long, Stone> idToStone = new HashMap<>();
    private static Map<Color, List<Stone>> byColor = Collections.emptyMap();
    private static Map<Transparency, List<Stone>> byTransparency = Collections.emptyMap();
    private static Map<String, List<Stone>> byClass = Collections.emptyMap();

    {
        save(Gemstone.newBuilder().withColor(Color.ORANGE).withPrice(3657).withTransparency(Transparency.VS1).withWeight(3.3).withType(EMERALD).withImg(EMERALD.getImgLink()).build());
        save(Gemstone.newBuilder().withColor(Color.RED).withPrice(6933).withTransparency(Transparency.SI1).withWeight(4.3).withType(ALEXANDRITE).withImg(ALEXANDRITE.getImgLink()).build());
        save(Gemstone.newBuilder().withColor(Color.GREEN).withPrice(8979).withTransparency(Transparency.I2).withWeight(2.1).withType(RUBY).withImg(RUBY.getImgLink()).build());
        save(Gemstone.newBuilder().withColor(Color.BLUE).withPrice(8532).withTransparency(Transparency.I2).withWeight(4.1).withType(DIAMOND).withImg(DIAMOND.getImgLink()).build());
        save(Gemstone.newBuilder().withColor(Color.BLACK).withPrice(6775).withTransparency(Transparency.VS1).withWeight(6.1).withType(ALEXANDRITE).withImg(ALEXANDRITE.getImgLink()).build());
        save(Gemstone.newBuilder().withColor(Color.RED).withPrice(12122).withTransparency(Transparency.I3).withWeight(4.6).withType(DIAMOND).withImg(DIAMOND.getImgLink()).build());
        save(Gemstone.newBuilder().withColor(Color.GREEN).withPrice(5455).withTransparency(Transparency.SI2).withWeight(4.3).withType(EMERALD).withImg(EMERALD.getImgLink()).build());

        save(SemipreciouStone.newBuilder().withColor(Color.GREEN).withPrice(3199).withTransparency(Transparency.VS1).withWeight(4.2).withType(TOPAZ).withImg(TOPAZ.getImgLink()).build());
        save(SemipreciouStone.newBuilder().withColor(Color.GREEN).withPrice(2333).withTransparency(Transparency.VS2).withWeight(3.1).withType(AQUAMARINE).withImg(AQUAMARINE.getImgLink()).build());
        save(SemipreciouStone.newBuilder().withColor(Color.RED).withPrice(1555).withTransparency(Transparency.VVS1).withWeight(3.5).withType(CHRYSOLITE).withImg(CHRYSOLITE.getImgLink()).build());
        save(SemipreciouStone.newBuilder().withColor(Color.ORANGE).withPrice(3442).withTransparency(Transparency.VS1).withWeight(4.1).withType(GARNET).withImg(GARNET.getImgLink()).build());
        save(SemipreciouStone.newBuilder().withColor(Color.ORANGE).withPrice(3442).withTransparency(Transparency.VS1).withWeight(4.1).withType(GARNET).withImg(GARNET.getImgLink()).build());


    }

    public void m() {
        updateIndices();
        for (Stone value : idToStone.values()) {
            System.out.println(value.getId());
        }
    }

    @Override
    public Stone save(Stone stone) {
        Long id = stone.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            stone.setId(id);
        }
        idToStone.put(id, stone);
        updateIndices();
        return idToStone.get(id);
    }


    @Override
    public void update(Stone stone) {
        save(stone);

    }

    @Override
    public Optional<Stone> findById(Long id) {
        return Optional.ofNullable(idToStone.get(id));
    }

    @Override
    public Stone deleteById(Long id) {
        Stone stone = idToStone.remove(id);
        updateIndices();
        return stone;
    }


    private void updateIndices() {
        byColor = idToStone.values().stream().collect(Collectors.groupingBy(Stone::getColor));
        byTransparency = idToStone.values().stream().collect(Collectors.groupingBy(Stone::getTransparency));
        Map<String, List<Stone>> map = new HashMap<>();
        for (Stone stone : idToStone.values()) {
            map.computeIfAbsent(stone.getClass().toString(), k -> new ArrayList<>()).add(stone);
        }
        byClass = map;

    }

    @Override
    public Integer size() {
        return idToStone.size();
    }

    @Override
    public Map<Long, Stone> getAll() {
        return idToStone;
    }

    @Override
    public Stone get(Long id) {
        return idToStone.get(id);
    }
}
