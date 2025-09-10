package org.example.subject;

import org.example.observer.Observer;

public class Channel implements Subject{
    private final String name;

    public Channel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title){
        // TODO: Notify all subscribers about new video
    }

    @Override
    public void subscribe(Observer observer) {
        // TODO: Add subscriber
    }

    @Override
    public void unsubscribe(Observer observer) {
        // TODO: Remove subscriber
    }

    @Override
    public void notifyObservers(String message) {
        // TODO: Notify subscribers
    }

    public String getName() {
        return name;
    }
}
