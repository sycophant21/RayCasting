# RayCasting

> Light doesn't know about walls — until it hits one.

A 2D **raycasting engine** built in Java Swing. A particle emits rays in all directions from the mouse cursor position. When rays hit obstacles, only the visible segments are drawn — the classic technique behind early 3D games like Wolfenstein 3D.

## What it does

- Renders a particle that tracks the mouse pointer in real time
- Casts rays outward from the particle in configurable angles
- Detects intersections between rays and rectangular/polygon obstacles
- Highlights only the illuminated portions of the scene

## How it works

Each `Ray` is defined by an origin point and a direction vector. On every frame, the engine checks every ray against every `Obstacle` boundary segment for the nearest intersection point using line–segment intersection math. `FieldGenerator` sets up the obstacle layout; `ObstacleCreator` and `ObstacleInitializer` manage instantiation. `MousePointerListener` feeds live cursor coordinates to the `Particle`. `Panel` renders each frame via Java2D.

## Tech stack

- **Java** (standard library)
- **Java Swing / Java2D** for rendering
- **AWT MouseMotionListener** for mouse tracking

## Getting started

### Prerequisites

- Java 8+
- IntelliJ IDEA or Eclipse

### Run

1. Open the project in your IDE (`src/` is the source root).
2. Run `Main.java`.
3. Move your mouse around the window to see the rays update in real time.

### Compile manually

```bash
javac -d out src/*.java
java -cp out Main
```

## Project structure

```
src/
├── Main.java                  # entry point, creates the JFrame
├── Panel.java                 # game loop + rendering
├── Particle.java              # the light source / ray origin
├── Ray.java                   # ray direction + intersection logic
├── Obstacle.java              # obstacle boundary segments
├── ObstacleCreator.java       # factory for obstacles
├── ObstacleInitializer.java   # scene setup
├── FieldGenerator.java        # lays out the obstacle field
├── MousePointerListener.java  # tracks cursor → updates particle
├── Coordinates.java           # 2D point/vector helper
└── Comparator.java            # intersection distance sorting
```
