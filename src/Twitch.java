

import java.util.*;
class Twitch {
    public static String[] solution(String[] streamerInformation, String[] commands) {
        HashMap<String, HashMap<String, String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < streamerInformation.length; i = i + 3) {
            String streamer = streamerInformation[i];
            String views = streamerInformation[i + 1];
            String category = streamerInformation[i + 2];
            HashMap<String, String> user = map.getOrDefault(category, new HashMap<String, String>());
            user.put(streamer, views);
            map.put(category, user);
        }
        int index = -1;
        while(index < commands.length-1){


            String command = commands[++index];
            String streamer = null, views = null, category = null;
            HashMap<String, String> user = new HashMap<>();
            switch (command) {
                case "StreamerOnline":
                    streamer = commands[++index];
                    views = commands[++index];
                    category = commands[++index];
                    user = map.getOrDefault(category, new HashMap<String, String>());
                    user.put(streamer, views);
                    map.put(category, user);
                    break;
                case "UpdateViews":
                    streamer = commands[++index];
                    views = commands[++index];
                    category = commands[++index];
                    user = map.getOrDefault(category, new HashMap<String, String>());
                    if(user.containsKey(streamer)){
                        user.put(streamer, views);
                    }
                    map.put(category,user);
                    break;
                case "UpdateCategory":
                    streamer = commands[++index];
                    category = commands[++index];
                    String toUpdate = commands[++index];

                    user = map.getOrDefault(category, new HashMap<String, String>());
                    if(user.containsKey(streamer)){
                        views = user.get(streamer);
                        user.remove(streamer);
                        HashMap<String, String> updateStreamerCategory = map.getOrDefault(toUpdate, new HashMap<String, String>());
                        updateStreamerCategory.put(streamer, views);
                        map.put(toUpdate, updateStreamerCategory);
                    }
                    break;
                case "StreamerOffline":
                    streamer = commands[++index];
                    category = commands[++index];
                    user = map.getOrDefault(category, new HashMap<String, String>());
                    if(user.containsKey(streamer)){
                        user.remove(streamer);
                    }
                    break;
                case "ViewsInCategory":

                    category = commands[++index];
                    user = map.getOrDefault(category, new HashMap<String, String>());
                    int totalView = 0 ;
                    for(Map.Entry<String, String> e : user.entrySet()){
                        totalView += Integer.valueOf(e.getValue());
                    }
                    res.add(String.valueOf(totalView));
                    break;
                case "TopStreamerInCategory":
                    category = commands[++index];
                    user = map.getOrDefault(category, new HashMap<String, String>());
                    String topStreamer = null;
                    int viewCount = Integer.MIN_VALUE;
                    for(Map.Entry<String, String> e : user.entrySet()){
                        if(viewCount < Integer.valueOf(e.getValue())){
                            topStreamer = e.getKey();
                            viewCount = Integer.valueOf(e.getValue());
                        }
                    }
                    res.add(topStreamer);
                    break;
                case "TopStreamer":
                    String topStreamerAllTime = "";
                    index++;
                    int viewCountALl = Integer.MIN_VALUE;
                    for(Map.Entry<String, HashMap<String, String>> all : map.entrySet()){
                        HashMap<String, String> cat = all.getValue();
                        for(Map.Entry<String, String> e : cat.entrySet()){
                            if(viewCountALl < Integer.valueOf(e.getValue())){
                                topStreamerAllTime = e.getKey();
                                viewCountALl = Integer.valueOf(e.getValue());
                            }
                        }
                    }
                    res.add(topStreamerAllTime);
                    break;
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

class practice{

}
