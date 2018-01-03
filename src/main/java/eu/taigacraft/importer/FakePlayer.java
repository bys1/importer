package eu.taigacraft.importer;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

public final class FakePlayer implements Player {
	
	private final OfflinePlayer player;
	
	public FakePlayer(final OfflinePlayer player) {
		this.player = player;
	}
	
	public String getName() {
		return player.getName();
	}
	
	public UUID getUniqueId() {
		return player.getUniqueId();
	}
	
	public void closeInventory() {}
	public Inventory getEnderChest() { return null; }
	public int getExpToLevel() { return 0; }
	public GameMode getGameMode() { return null; }
	public PlayerInventory getInventory() { return null; }
	public ItemStack getItemInHand() { return null; }
	public ItemStack getItemOnCursor() { return null; }
	public MainHand getMainHand() { return null; }
	public InventoryView getOpenInventory() { return null; }
	public int getSleepTicks() { return 0; }
	public boolean isBlocking() { return false; }
	public boolean isSleeping() { return false; }
	public InventoryView openEnchanting(Location arg0, boolean arg1) { return null; }
	public InventoryView openInventory(Inventory inventory) { return null; }
	public void openInventory(InventoryView inventory) {}
	public InventoryView openMerchant(Villager trader, boolean force) { return null; }
	public InventoryView openWorkbench(Location location, boolean force) { return null; }
	public void setGameMode(GameMode mode) {}
	public void setItemInHand(ItemStack item) {}
	public void setItemOnCursor(ItemStack item) {}
	public boolean setWindowProperty(Property prop, int value) { return false; }
	public int _INVALID_getLastDamage() { return 0; }
	public void _INVALID_setLastDamage(int damage) {}
	public boolean addPotionEffect(PotionEffect effect) { return false; }
	public boolean addPotionEffect(PotionEffect effect, boolean force) { return false; }
	public boolean addPotionEffects(Collection<PotionEffect> effects) { return false; }
	public Collection<PotionEffect> getActivePotionEffects() { return null; }
	public boolean getCanPickupItems() { return false; }
	public EntityEquipment getEquipment() { return null; }
	public double getEyeHeight() { return 0; }
	public double getEyeHeight(boolean ignoreSneaking) { return 0; }
	public Location getEyeLocation() { return null; }
	public Player getKiller() { return null; }
	public double getLastDamage() { return 0; }
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) { return null; }
	public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) { return null; }
	public Entity getLeashHolder() throws IllegalStateException { return null; }
	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) { return null; }
	public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) { return null; }
	public int getMaximumAir() { return 0; }
	public int getMaximumNoDamageTicks() { return 0; }
	public int getNoDamageTicks() { return 0; }
	public int getRemainingAir() { return 0; }
	public boolean getRemoveWhenFarAway() { return false; }
	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) { return null; }
	public Block getTargetBlock(Set<Material> transparent, int maxDistance) { return null; }
	public boolean hasAI() { return false; }
	public boolean hasLineOfSight(Entity other) { return false; }
	public boolean hasPotionEffect(PotionEffectType type) { return false; }
	public boolean isCollidable() { return false; }
	public boolean isGliding() { return false; }
	public boolean isLeashed() { return false; }
	public void removePotionEffect(PotionEffectType type) {}
	public void setAI(boolean ai) {}
	public void setCanPickupItems(boolean pickup) {}
	public void setCollidable(boolean collidable) {}
	public void setGliding(boolean gliding) {}
	public void setLastDamage(double damage) {}
	public boolean setLeashHolder(Entity holder) { return false; }
	public void setMaximumAir(int ticks) {}
	public void setMaximumNoDamageTicks(int ticks) {}
	public void setNoDamageTicks(int ticks) {}
	public void setRemainingAir(int ticks) {}
	public void setRemoveWhenFarAway(boolean remove) {}
	public AttributeInstance getAttribute(Attribute attribute) { return null; }
	public boolean eject() { return false; }
	public String getCustomName() { return null; }
	public int getEntityId() { return 0; }
	public float getFallDistance() { return 0; }
	public int getFireTicks() { return 0; }
	public EntityDamageEvent getLastDamageCause() { return null; }
	public Location getLocation() { return null; }
	public Location getLocation(Location loc) { return null; }
	public int getMaxFireTicks() { return 0; }
	public List<Entity> getNearbyEntities(double x, double y, double z) { return null; }
	public Entity getPassenger() { return null; }
	public Server getServer() { return null; }
	public int getTicksLived() { return 0; }
	public EntityType getType() { return null; }
	public Entity getVehicle() { return null; }
	public Vector getVelocity() { return null; }
	public World getWorld() { return null; }
	public boolean hasGravity() { return false; }
	public boolean isCustomNameVisible() { return false; }
	public boolean isDead() { return false; }
	public boolean isEmpty() { return false; }
	public boolean isGlowing() { return false; }
	public boolean isInsideVehicle() { return false; }
	public boolean isInvulnerable() { return false; }
	public boolean isSilent() { return false; }
	public boolean isValid() { return false; }
	public boolean leaveVehicle() { return false; }
	public void playEffect(EntityEffect type) {}
	public void remove() {}
	public void setCustomName(String name) {}
	public void setCustomNameVisible(boolean flag) {}
	public void setFallDistance(float distance) {}
	public void setFireTicks(int ticks) {}
	public void setGlowing(boolean flag) {}
	public void setGravity(boolean gravity) {}
	public void setInvulnerable(boolean flag) {}
	public void setLastDamageCause(EntityDamageEvent event) {}
	public boolean setPassenger(Entity passenger) { return false; }
	public void setSilent(boolean flag) {}
	public void setTicksLived(int value) {}
	public void setVelocity(Vector velocity) {}
	public boolean teleport(Location location) { return false; }
	public boolean teleport(Entity destination) { return false; }
	public boolean teleport(Location location, TeleportCause cause) { return false; }
	public boolean teleport(Entity destination, TeleportCause cause) { return false; }
	public List<MetadataValue> getMetadata(String metadataKey) { return null; }
	public boolean hasMetadata(String metadataKey) { return false; }
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {}
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {}
	public void sendMessage(String message) {}
	public void sendMessage(String[] messages) {}
	public PermissionAttachment addAttachment(Plugin plugin) { return null; }
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) { return null; }
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) { return null; }
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) { return null; }
	public Set<PermissionAttachmentInfo> getEffectivePermissions() { return null; }
	public boolean hasPermission(String name) { return false; }
	public boolean hasPermission(Permission perm) { return false; }
	public boolean isPermissionSet(String name) { return false; }
	public boolean isPermissionSet(Permission perm) { return false; }
	public void recalculatePermissions() {}
	public void removeAttachment(PermissionAttachment attachment) {}
	public boolean isOp() { return false; }
	public void setOp(boolean value) {}
	public void _INVALID_damage(int amount) {}
	public void _INVALID_damage(int amount, Entity source) {}
	public int _INVALID_getHealth() { return 0; }
	public int _INVALID_getMaxHealth() { return 0; }
	public void _INVALID_setHealth(int health) {}
	public void _INVALID_setMaxHealth(int health) {}
	public void damage(double amount) {}
	public void damage(double amount, Entity source) {}
	public double getHealth() { return 0; }
	public double getMaxHealth() { return 0; }
	public void resetMaxHealth() {}
	public void setHealth(double health) {}
	public void setMaxHealth(double health) {}
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) { return null; }
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) { return null; }
	public void abandonConversation(Conversation conversation) {}
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {}
	public void acceptConversationInput(String input) {}
	public boolean beginConversation(Conversation conversation) { return false; }
	public boolean isConversing() { return false; }
	public long getFirstPlayed() { return 0; }
	public long getLastPlayed() { return 0; }
	public Player getPlayer() { return null; }
	public boolean hasPlayedBefore() { return false; }
	public boolean isBanned() { return false; }
	public boolean isOnline() { return false; }
	public boolean isWhitelisted() { return false; }
	public void setBanned(boolean banned) {}
	public void setWhitelisted(boolean value) {}
	public Map<String, Object> serialize() { return null; }
	public Set<String> getListeningPluginChannels() { return null; }
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {}
	public void awardAchievement(Achievement achievement) {}
	public boolean canSee(Player player) { return false; }
	public void chat(String msg) {}
	public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {}
	public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {}
	public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {}
	public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {}
	public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {}
	public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {}
	public InetSocketAddress getAddress() { return null; }
	public boolean getAllowFlight() { return false; }
	public Location getBedSpawnLocation() { return null; }
	public Location getCompassTarget() { return null; }
	public String getDisplayName() { return null; }
	public float getExhaustion() { return 0; }
	public float getExp() { return 0; }
	public float getFlySpeed() { return 0; }
	public int getFoodLevel() { return 0; }
	public double getHealthScale() { return 0; }
	public int getLevel() { return 0; }
	public String getPlayerListName() { return null; }
	public long getPlayerTime() { return 0; }
	public long getPlayerTimeOffset() { return 0; }
	public WeatherType getPlayerWeather() { return null; }
	public float getSaturation() { return 0; }
	public Scoreboard getScoreboard() { return null; }
	public Entity getSpectatorTarget() { return null; }
	public int getStatistic(Statistic statistic) throws IllegalArgumentException { return 0; }
	public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException { return 0; }
	public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException { return 0; }
	public int getTotalExperience() { return 0; }
	public float getWalkSpeed() { return 0; }
	public void giveExp(int amount) {}
	public void giveExpLevels(int amount) {}
	public boolean hasAchievement(Achievement achievement) { return false; }
	public void hidePlayer(Player player) {}
	public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {}
	public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {}
	public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {}
	public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {}
	public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {}
	public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException {}
	public boolean isFlying() { return false; }
	public boolean isHealthScaled() { return false; }
	public boolean isOnGround() { return false; }
	public boolean isPlayerTimeRelative() { return false; }
	public boolean isSleepingIgnored() { return false; }
	public boolean isSneaking() { return false; }
	public boolean isSprinting() { return false; }
	public void kickPlayer(String message) {}
	public void loadData() {}
	public boolean performCommand(String command) { return false; }
	public void playEffect(Location loc, Effect effect, int data) {}
	public <T> void playEffect(Location loc, Effect effect, T data) {}
	public void playNote(Location loc, byte instrument, byte note) {}
	public void playNote(Location loc, Instrument instrument, Note note) {}
	public void playSound(Location location, Sound sound, float volume, float pitch) {}
	public void playSound(Location location, String sound, float volume, float pitch) {}
	public void removeAchievement(Achievement achievement) {}
	public void resetPlayerTime() {}
	public void resetPlayerWeather() {}
	public void resetTitle() {}
	public void saveData() {}
	public void sendBlockChange(Location loc, Material material, byte data) {}
	public void sendBlockChange(Location loc, int material, byte data) {}
	public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) { return false; }
	public void sendMap(MapView map) {}
	public void sendRawMessage(String message) {}
	public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {}
	public void sendTitle(String title, String subtitle) {}
	public void setAllowFlight(boolean flight) {}
	public void setBedSpawnLocation(Location location) {}
	public void setBedSpawnLocation(Location location, boolean force) {}
	public void setCompassTarget(Location loc) {}
	public void setDisplayName(String name) {}
	public void setExhaustion(float value) {}
	public void setExp(float exp) {}
	public void setFlySpeed(float value) throws IllegalArgumentException {}
	public void setFlying(boolean value) {}
	public void setFoodLevel(int value) {}
	public void setHealthScale(double scale) throws IllegalArgumentException {}
	public void setHealthScaled(boolean scale) {}
	public void setLevel(int level) {}
	public void setPlayerListName(String name) {}
	public void setPlayerTime(long time, boolean relative) {}
	public void setPlayerWeather(WeatherType type) {}
	public void setResourcePack(String url) {}
	public void setSaturation(float value) {}
	public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {}
	public void setSleepingIgnored(boolean isSleeping) {}
	public void setSneaking(boolean sneak) {}
	public void setSpectatorTarget(Entity entity) {}
	public void setSprinting(boolean sprinting) {}
	public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {}
	public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {}
	public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {}
	public void setTexturePack(String url) {}
	public void setTotalExperience(int exp) {}
	public void setWalkSpeed(float value) throws IllegalArgumentException {}
	public void showPlayer(Player player) {}
	public void spawnParticle(Particle particle, Location location, int count) {}
	public <T> void spawnParticle(Particle particle, Location location, int count, T data) {}
	public void spawnParticle(Particle particle, double x, double y, double z, int count) {}
	public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data) {}
	public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY,
			double offsetZ) {}
	public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX,
			double offsetY, double offsetZ, T data) {}
	public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY,
			double offsetZ, double extra) {}
	public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
			double offsetY, double offsetZ) {}
	public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX,
			double offsetY, double offsetZ, double extra, T data) {}
	public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
			double offsetY, double offsetZ, T data) {}
	public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
			double offsetY, double offsetZ, double extra) {}
	public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
			double offsetY, double offsetZ, double extra, T data) {}
	public Spigot spigot() { return null; }
	public void stopSound(Sound sound) {}
	public void stopSound(String sound) {}
	public void updateInventory() {}
}
