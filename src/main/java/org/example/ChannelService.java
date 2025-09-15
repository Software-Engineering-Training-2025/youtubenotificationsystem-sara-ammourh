package org.example;

import org.example.observer.Observer;
import org.example.subject.Channel;
import org.example.subject.Subject;

import java.util.*;


public class ChannelService {

    private final Map<String, Channel> channels = new HashMap<>();

    public boolean createChannel(String name) {
        if (name == null || name.isEmpty() || channels.containsKey(name)) {
            return false;
        }
        Channel newChannel = new Channel(name);
        channels.put(name, newChannel);
        return true;
    }

    public boolean deleteChannel(String name) {
        if (channels.containsKey(name)) {
            channels.remove(name);
            return true;
        }
        return false;
    }

    public Optional<Channel> getChannel(String name) {
        return Optional.ofNullable(channels.get(name));
    }

    public boolean subscribe(String channelName, Observer user) {
        Optional<Channel> channel = getChannel(channelName);
        if (channel.isPresent() && user != null) {
            channel.get().subscribe(user);
            return true;
        }
        return false;
    }

    public boolean unsubscribe(String channelName, Observer user) {
        Optional<Channel> channel = getChannel(channelName);
        if (channel.isPresent() &&  user != null) {
            channel.get().unsubscribe(user);
            return true;
        }
        return false;
    }

    public boolean upload(String channelName, String videoTitle) {
        Optional<Channel> channel = getChannel(channelName);
        if (channel.isPresent()) {
            channel.get().uploadVideo(videoTitle);
            return true;
        }
        return false;
    }

    public Set<String> listChannels() {
        return new HashSet<>(channels.keySet());
    }
}
