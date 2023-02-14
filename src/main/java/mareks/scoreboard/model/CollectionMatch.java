package mareks.scoreboard.model;

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

    public void updateMatch(Match newDataForMatch) {
        hashMap.put(newDataForMatch.getUUID(), newDataForMatch);
    }

    public void deleteMatch(Match oldMatch) {
        hashMap.remove(oldMatch.getUUID());
    }
}
