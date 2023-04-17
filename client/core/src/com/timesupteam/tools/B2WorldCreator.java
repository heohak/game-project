package com.timesupteam.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.timesupteam.sprites.Keys;
import com.timesupteam.TimesUpTeamGame;
import com.timesupteam.screens.PlayScreen;
import com.timesupteam.sprites.EndDoor;
import com.timesupteam.sprites.StartDoor;
import com.timesupteam.sprites.Walls;

public class B2WorldCreator {
    public B2WorldCreator(PlayScreen screen, KeysManager keysManager) {
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

    //        // Create fixtures for walls
    //        for (RectangleMapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
    //            Rectangle rect = object.getRectangle();
    //            new Walls(screen , rect);
    //        }

        // Iterate over each tile and create a wall if it exists
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get("top");
        for (int x = 0; x < layer.getWidth(); x++) {
            for (int y = 0; y < layer.getHeight(); y++) {
                if (layer.getCell(x, y) == null) continue;

                Rectangle rect = new Rectangle(
                        x * layer.getTileWidth(), y * layer.getTileHeight(),
                        layer.getTileWidth(), layer.getTileHeight());
                new Walls(screen, rect);
            }
        }

        TiledMapTileLayer keylayer = (TiledMapTileLayer) map.getLayers().get("keylayer");
        for (int x = 0; x < keylayer.getWidth(); x++) {
            for (int y = 0; y < keylayer.getHeight(); y++) {
                if (keylayer.getCell(x, y) == null) continue;

                Rectangle rect = new Rectangle(
                        x * keylayer.getTileWidth(), y * keylayer.getTileHeight(),
                        keylayer.getTileWidth(), keylayer.getTileHeight());
                keysManager.addKey(new Keys(screen, rect, keysManager, keysManager.getKeyIdAndIncrement()));
            }
        }

        // Doors
        // todo: change .get(number) to .get(string)
//        for (RectangleMapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
//            Rectangle rect = object.getRectangle();
//            new StartDoor(screen , rect);
//        }
//        for (RectangleMapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
//            Rectangle rect = object.getRectangle();
//            new EndDoor(screen , rect);
//        }

        //// Create fixtures for keys, and add each key to KeysManager
        //for (RectangleMapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
        //    Rectangle rect = object.getRectangle();
        //    keysManager.addKey(new Keys(screen, rect, keysManager, keysManager.getKeyIdAndIncrement()));
        //}
    }
}
