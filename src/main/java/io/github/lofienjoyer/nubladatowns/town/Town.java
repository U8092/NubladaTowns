package io.github.lofienjoyer.nubladatowns.town;

import io.github.lofienjoyer.nubladatowns.roles.Role;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Town {

    private final UUID uniqueId;
    private String name;
    private int rgbColor;
    private final List<UUID> residents;
    private final List<LandChunk> claimedLand;
    private Location spawn;
    private boolean open;
    private UUID mayor;
    private List<Role> roles = new ArrayList<>();

    public Town(UUID uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.residents = new ArrayList<>();
        this.claimedLand = new ArrayList<>();
    }

    public Town(String name) {
        this(UUID.randomUUID(), name);
    }

    protected void addLand(LandChunk chunk) {
        claimedLand.add(chunk);
    }

    protected void addLand(int x, int z, World world) {
        var landChunk = new LandChunk(x, z, world);
        claimedLand.add(landChunk);
    }

    protected void addResident(UUID uuid) {
        residents.add(uuid);
    }

    protected void addResident(Player player) {
        addResident(player.getUniqueId());
    }

    public List<UUID> getResidents() {
        return Collections.unmodifiableList(residents);
    }

    public List<LandChunk> getClaimedLand() {
        return Collections.unmodifiableList(claimedLand);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Location getSpawn() {
        return spawn;
    }

    protected void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public int getRgbColor() {
        return rgbColor;
    }

    protected void setRgbColor(int rgbColor) {
        this.rgbColor = rgbColor;
    }

    public boolean isOpen() {
        return open;
    }

    protected void setOpen(boolean open) {
        this.open = open;
    }

    protected void setMayor(UUID uuid) { this.mayor = uuid; }

    protected void setMayor(Player player) { setMayor(player.getUniqueId()); }

    public UUID getMayor() { return mayor; }

    public void addRole(Role role) { this.roles.add(role); }

    public void removeRole(Role role) { this.roles.remove(role); }

    public List<Role> getRoles() { return roles; }

    public Role getRole(String name) {
        for (Role role : roles) {
            if(role.getName().equals(name)) return role;
        }

        return null;
    }

    protected void setRoles(List<Role> roles) { this.roles = roles; }
}
