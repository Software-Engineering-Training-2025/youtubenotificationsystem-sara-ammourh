package org.example;

import org.example.observer.User;

public class Main {
    public static void main(String[] args) {
        // TODO:
        // 1. Create some Channels
        // 2. Create some Users
        // 3. Subscribe Users to Channels
        // 4. Upload videos and see notifications propagate

        ChannelService svc = new ChannelService();
        svc.createChannel("TechWorld");
        svc.createChannel("FoodiesUnite");

        User alice = new User("Alice");
        User bob   = new User("Bob");
        User charlie = new User("Charlie");

        svc.subscribe("TechWorld", alice);
        svc.subscribe("TechWorld", bob);

        svc.subscribe("FoodiesUnite", alice);
        svc.subscribe("FoodiesUnite", charlie);

        svc.upload("TechWorld", "Observer Pattern Explained");
        svc.upload("FoodiesUnite", "Best Pasta Recipe");
    }
}