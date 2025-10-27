import random
import time
import json
import os
from enum import Enum

# Constants for game balance
XP_MULTIPLIER = 100
POTION_HEAL = 50
CRITICAL_MULTIPLIER = 1.5
DODGE_CHANCE = 0.2

class CharacterClass(Enum):
    WARRIOR = "Warrior"
    MAGE = "Mage"
    THIEF = "Thief"

class Player:
    def __init__(self, name, character_class):
        self.name = name
        self.character_class = character_class
        self.level = 1
        self.experience = 0
        self.gold = 50
        self.inventory = ["Health Potion", "Health Potion"]
        
        # Base stats based on class
        base_stats = {
            CharacterClass.WARRIOR: {"health": 120, "attack": 15, "defense": 10, "dodge": 0.1},
            CharacterClass.MAGE: {"health": 80, "attack": 20, "defense": 5, "dodge": 0.15},
            CharacterClass.THIEF: {"health": 90, "attack": 12, "defense": 7, "dodge": 0.25}
        }
        
        stats = base_stats[character_class]
        self.max_health = stats["health"]
        self.health = self.max_health
        self.attack = stats["attack"]
        self.defense = stats["defense"]
        self.dodge_chance = stats["dodge"]
        self.special_charges = 3
    
    def is_alive(self):
        return self.health > 0
    
    def level_up(self):
        levels_gained = 0
        while self.experience >= self.level * XP_MULTIPLIER:
            self.experience -= self.level * XP_MULTIPLIER
            self.level += 1
            levels_gained += 1
            
            # Stat increases based on class
            if self.character_class == CharacterClass.WARRIOR:
                self.max_health += 20
                self.attack += 4
                self.defense += 3
            elif self.character_class == CharacterClass.MAGE:
                self.max_health += 10
                self.attack += 6
                self.defense += 1
            else:  # THIEF
                self.max_health += 15
                self.attack += 3
                self.defense += 2
                self.dodge_chance = min(0.4, self.dodge_chance + 0.02)
            
            self.health = self.max_health  # Full heal on level up
            self.special_charges += 1
        
        if levels_gained > 0:
            print(f"🎉 {self.name} leveled up to level {self.level}!")
            print(f"❤️  Max Health: {self.max_health}")
            print(f"⚔️  Attack: {self.attack}")
            print(f"🛡️  Defense: {self.defense}")
            if self.character_class == CharacterClass.THIEF:
                print(f"🌀 Dodge Chance: {self.dodge_chance:.1%}")
            return True
        return False
    
    def use_special_ability(self, enemy):
        """Class-specific special abilities"""
        if self.special_charges <= 0:
            print("❌ No special charges remaining!")
            return False
        
        self.special_charges -= 1
        
        if self.character_class == CharacterClass.WARRIOR:
            # Warrior: Powerful strike that ignores some defense
            damage = int(self.attack * 1.8 - (enemy.defense * 0.5))
            enemy.health -= max(1, damage)
            print(f"💥 WARRIOR'S MIGHT! You strike for {damage} damage!")
            
        elif self.character_class == CharacterClass.MAGE:
            # Mage: Fireball that always hits
            damage = self.attack + random.randint(5, 15)
            enemy.health -= damage
            print(f"🔥 FIREBALL! You burn the enemy for {damage} damage!")
            
        else:  # THIEF
            # Thief: Poison that does damage over time
            poison_damage = self.attack // 2
            enemy.health -= poison_damage
            # Add poison effect (simplified as immediate extra damage)
            extra_damage = poison_damage // 2
            enemy.health -= extra_damage
            print(f"☠️  DEADLY POISON! You deal {poison_damage} + {extra_damage} poison damage!")
        
        return True
    
    def use_item(self, item_index):
        """Use item from inventory"""
        if item_index < 0 or item_index >= len(self.inventory):
            return False
        
        item = self.inventory[item_index]
        
        if item == "Health Potion":
            heal_amount = min(POTION_HEAL, self.max_health - self.health)
            self.health += heal_amount
            self.inventory.pop(item_index)
            print(f"🧪 Used Health Potion! Healed {heal_amount} HP.")
            return True
        
        return False

class Enemy:
    def __init__(self, name, level):
        self.name = name
        self.level = level
        
        # Non-linear scaling
        self.max_health = int(30 * (1.3 ** (level - 1)))
        self.health = self.max_health
        self.attack = int(8 * (1.2 ** (level - 1)))
        self.defense = int(3 * (1.15 ** (level - 1)))
        self.gold_reward = random.randint(5, 20) * level
        self.exp_reward = 25 * level
        
        # Special abilities for some enemies
        self.special_ability = random.choice([None, "double_attack", "heal", "poison"])
    
    def is_alive(self):
        return self.health > 0
    
    def perform_special_ability(self, player):
        """Enemy special abilities"""
        if not self.special_ability or random.random() > 0.3:  # 30% chance to use special
            return False
        
        if self.special_ability == "double_attack":
            damage = max(1, self.attack - player.defense + random.randint(-2, 2))
            player.health -= damage
            print(f"⚡ {self.name} uses DOUBLE STRIKE! Deals {damage} damage!")
            return True
            
        elif self.special_ability == "heal":
            heal_amount = self.max_health // 4
            self.health = min(self.max_health, self.health + heal_amount)
            print(f"💚 {self.name} heals for {heal_amount} HP!")
            return True
            
        elif self.special_ability == "poison":
            poison_damage = self.attack // 3
            player.health -= poison_damage
            print(f"☠️  {self.name} poisons you for {poison_damage} damage!")
            return True
        
        return False

def display_stats(player):
    """Display player statistics"""
    print(f"\n{'='*50}")
    print(f"🧙 {player.name} the {player.character_class.value}")
    print(f"📊 Level: {player.level} | XP: {player.experience}/{player.level * XP_MULTIPLIER}")
    print(f"❤️  Health: {player.health}/{player.max_health}")
    print(f"⚔️  Attack: {player.attack} | 🛡️ Defense: {player.defense}")
    if player.character_class == CharacterClass.THIEF:
        print(f"🌀 Dodge Chance: {player.dodge_chance:.1%}")
    print(f"💰 Gold: {player.gold}")
    print(f"🎯 Special Charges: {player.special_charges}")
    print(f"🎒 Inventory: {', '.join(player.inventory) if player.inventory else 'Empty'}")
    print(f"{'='*50}")

def attack_target(attacker, defender, is_critical=False):
    """Handle attack between two entities"""
    if random.random() < getattr(defender, 'dodge_chance', 0):
        print(f"💨 {defender.name} dodged the attack!")
        return 0
    
    base_damage = attacker.attack - defender.defense + random.randint(-2, 3)
    damage = max(1, base_damage)
    
    if is_critical or random.random() < 0.1:  # 10% critical chance
        damage = int(damage * CRITICAL_MULTIPLIER)
        print(f"💥 CRITICAL HIT! ", end="")
    
    defender.health -= damage
    return damage

def combat(player, enemy):
    """Enhanced combat system"""
    print(f"\n⚔️ A wild {enemy.name} (Level {enemy.level}) appears!")
    
    turn = 0
    while player.is_alive() and enemy.is_alive():
        turn += 1
        print(f"\n——— Turn {turn} ———")
        print(f"{player.name}: {player.health}/{player.max_health} HP")
        print(f"{enemy.name}: {enemy.health}/{enemy.max_health} HP")
        
        # Player's turn
        action = get_combat_choice(player)
        
        if action == '1':  # Attack
            damage = attack_target(player, enemy)
            if damage > 0:
                print(f"💥 You deal {damage} damage to {enemy.name}!")
        
        elif action == '2':  # Special Ability
            if not player.use_special_ability(enemy):
                continue  # Invalid special, try again
        
        elif action == '3':  # Use Item
            if not use_item_in_combat(player):
                continue  # No valid item used, try again
        
        elif action == '4':  # Flee
            if random.random() < 0.6:  # 60% chance to flee
                print("🏃 You successfully fled!")
                return False
            else:
                print("❌ You couldn't escape!")
        
        # Check if enemy defeated
        if not enemy.is_alive():
            break
        
        # Enemy's turn
        print(f"\n{enemy.name}'s turn...")
        time.sleep(1)
        
        # Chance for special ability
        if not enemy.perform_special_ability(player):
            # Normal attack
            damage = attack_target(enemy, player)
            if damage > 0:
                print(f"💢 {enemy.name} deals {damage} damage to you!")
    
    # Combat conclusion
    if player.is_alive():
        victory_rewards(player, enemy)
        return True
    else:
        print("💀 You have been defeated...")
        return False

def get_combat_choice(player):
    """Get valid combat choice from player"""
    while True:
        print(f"\nChoose action:")
        print("1. ⚔️  Attack")
        print("2. ✨ Special Ability")
        print("3. 🎒 Use Item")
        print("4. 🏃 Flee")
        
        choice = input("Enter your choice (1-4): ").strip()
        if choice in ['1', '2', '3', '4']:
            return choice
        print("❌ Invalid choice. Please enter 1-4.")

def use_item_in_combat(player):
    """Handle item usage during combat"""
    if not player.inventory:
        print("❌ Your inventory is empty!")
        return False
    
    print("\n🎒 Inventory:")
    for i, item in enumerate(player.inventory, 1):
        print(f"{i}. {item}")
    print(f"{len(player.inventory) + 1}. Cancel")
    
    try:
        choice = int(input("Choose item to use: ")) - 1
        if choice == len(player.inventory):
            return False  # Cancel
        return player.use_item(choice)
    except (ValueError, IndexError):
        print("❌ Invalid choice.")
        return False

def victory_rewards(player, enemy):
    """Handle rewards after winning combat"""
    print(f"🎯 You defeated {enemy.name}!")
    player.gold += enemy.gold_reward
    player.experience += enemy.exp_reward
    print(f"💰 Gained {enemy.gold_reward} gold")
    print(f"🌟 Gained {enemy.exp_reward} experience")
    
    # Item drop chance
    if random.random() < 0.4:  # 40% chance for item
        items = ["Health Potion", "Health Potion", "Health Potion", "Magic Scroll", "Iron Sword", "Wooden Shield"]
        found_item = random.choice(items)
        player.inventory.append(found_item)
        print(f"🎁 Found {found_item}!")
    
    # Level up check
    player.level_up()

def random_event(player):
    """Random events while exploring"""
    events = [
        ("treasure", "You found a hidden treasure chest! +50 gold.", lambda p: setattr(p, 'gold', p.gold + 50)),
        ("mysterious_stranger", "A mysterious stranger gives you a Health Potion.", lambda p: p.inventory.append("Health Potion")),
        ("trap", "You triggered a trap! -10 HP.", lambda p: setattr(p, 'health', max(1, p.health - 10))),
        ("fountain", "You found a healing fountain! Health restored.", lambda p: setattr(p, 'health', p.max_health)),
    ]
    
    event = random.choice(events)
    print(f"\n🗺️  {event[1]}")
    event[2](player)
    return event[0]

def save_game(player):
    """Save game to file"""
    data = {
        'name': player.name,
        'character_class': player.character_class.value,
        'level': player.level,
        'experience': player.experience,
        'gold': player.gold,
        'inventory': player.inventory,
        'health': player.health,
        'max_health': player.max_health,
        'attack': player.attack,
        'defense': player.defense,
        'dodge_chance': player.dodge_chance,
        'special_charges': player.special_charges
    }
    
    with open('rpg_save.json', 'w') as f:
        json.dump(data, f)
    print("💾 Game saved successfully!")

def load_game():
    """Load game from file"""
    try:
        with open('rpg_save.json', 'r') as f:
            data = json.load(f)
        
        player = Player(data['name'], CharacterClass(data['character_class']))
        player.level = data['level']
        player.experience = data['experience']
        player.gold = data['gold']
        player.inventory = data['inventory']
        player.health = data['health']
        player.max_health = data['max_health']
        player.attack = data['attack']
        player.defense = data['defense']
        player.dodge_chance = data['dodge_chance']
        player.special_charges = data['special_charges']
        
        print("📂 Game loaded successfully!")
        return player
    except FileNotFoundError:
        print("❌ No saved game found.")
        return None
    except Exception as e:
        print(f"❌ Error loading game: {e}")
        return None

def create_character():
    """Create a new character"""
    print("🧙 Create Your Character")
    name = input("Enter your character's name: ").strip()
    if not name:
        name = "Hero"
    
    print("\nChoose your class:")
    print("1. 🛡️  Warrior - High health and defense")
    print("2. 🔥 Mage - Powerful attacks, low defense")  
    print("3. 🗡️  Thief - High dodge chance, balanced")
    
    while True:
        choice = input("Enter class (1-3): ").strip()
        if choice == '1':
            char_class = CharacterClass.WARRIOR
            break
        elif choice == '2':
            char_class = CharacterClass.MAGE
            break
        elif choice == '3':
            char_class = CharacterClass.THIEF
            break
        else:
            print("❌ Invalid choice. Please enter 1-3.")
    
    player = Player(name, char_class)
    print(f"\n✨ Welcome, {name} the {char_class.value}!")
    return player

def main():
    """Main game loop"""
    print("🐉 Welcome to Enhanced Python RPG! 🐉")
    
    # Load or create character
    player = None
    if os.path.exists('rpg_save.json'):
        load_choice = input("Load saved game? (y/n): ").strip().lower()
        if load_choice == 'y':
            player = load_game()
    
    if not player:
        player = create_character()
    
    enemies = ["Goblin", "Skeleton", "Orc", "Dragon", "Witch", "Zombie", "Vampire", "Giant Spider"]
    
    while player.is_alive():
        display_stats(player)
        
        print("\nChoose your action:")
        print("1. 🗺️  Explore")
        print("2. 🛌 Rest (restore health)")
        print("3. 🎒 Use Item")
        print("4. 💾 Save Game")
        print("5. 🚪 Quit Game")
        
        choice = input("Enter your choice (1-5): ").strip()
        
        if choice == '1':  # Explore
            # Random event chance
            if random.random() < 0.3:  # 30% chance for random event
                random_event(player)
            else:
                enemy = Enemy(random.choice(enemies), player.level + random.randint(-1, 2))
                if not combat(player, enemy):
                    break
        
        elif choice == '2':  # Rest
            heal_amount = min(30, player.max_health - player.health)
            player.health += heal_amount
            print(f"💤 You rest and recover {heal_amount} health")
            # Random encounter while resting
            if random.random() < 0.2:
                print("🌙 You were ambushed during rest!")
                enemy = Enemy(random.choice(enemies), player.level)
                if not combat(player, enemy):
                    break
        
        elif choice == '3':  # Use Item
            if not use_item_in_combat(player):
                print("❌ No valid item used.")
        
        elif choice == '4':  # Save Game
            save_game(player)
        
        elif choice == '5':  # Quit
            save_choice = input("Save before quitting? (y/n): ").strip().lower()
            if save_choice == 'y':
                save_game(player)
            print("Thanks for playing! 👋")
            break
        
        else:
            print("❌ Invalid choice. Please try again.")
        
        # Small delay for better pacing
        time.sleep(1)
    
    if not player.is_alive():
        print(f"\nGame Over! Final stats:")
        display_stats(player)

if __name__ == "__main__":
    main()