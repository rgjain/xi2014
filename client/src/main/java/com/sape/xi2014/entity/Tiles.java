package com.sape.xi2014.entity;

import java.util.List;

public class Tiles {
  
  Integer count; 
  
  List<Tile> tiles;

  public Tiles() {
    super();
    
  }
  public Tiles(List<Tile> tiles) {
    this.tiles = tiles;
  }

  public List<Tile> getTiles() {
    return tiles;
  }

  public void setTiles(List<Tile> tiles) {
    this.tiles = tiles;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

}
