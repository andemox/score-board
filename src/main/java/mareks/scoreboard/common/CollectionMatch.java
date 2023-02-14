package mareks.scoreboard.common;

import java.util.HashMap;
import java.util.UUID;

public class CollectionMatch {

    HashMap<UUID, Match> hashMap;

    public CollectionMatch() {
        hashMap = new HashMap<>(16);
    }

    public void add(Match match) {
        hashMap.put(match.getUUID(), match);
    }

    public int size() {
        return hashMap.size();
    }

    public Match get(UUID uuid) {
        return hashMap.get(uuid);
    }
    @SuppressWarnings("unused")
    public void updateMatch(Match newDataForMatch) {

    }
}
