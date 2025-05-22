// src/test/java/AttackTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Verifies correct object creation and initialisation, including edge cases.
public class AttackTest {

    // Tests the Attack constructor and attribute assignment for a  scenario. Serves as a basic validation of object creation.
    @Test
    public void testAttackCreationStandard() {
        Attack spell = new Attack("Expelliarmus", 50, false, true, 0.5);

        assertEquals("Expelliarmus", spell.name, "Attack name must be 'Expelliarmus'.");
        assertEquals(50, spell.damage, "Attack damage must be 50.");
        assertFalse(spell.skipOpponentTurn, "skipOpponentTurn must be false.");
        assertTrue(spell.reduceNextDamage, "reduceNextDamage must be true.");
        assertEquals(0.5, spell.damageReductionFactor, 0.001, "Damage reduction factor must be 0.5.");
    }

    // Tests Attack object creation with zero damage. Boundary case for non-damaging abilities like buffs or shields.
    @Test
    public void testAttackCreationZeroDamage() {
        Attack buffSpell = new Attack("Shield Charm", 0, false, true, 0.8);

        assertEquals("Shield Charm", buffSpell.name, "Spell name must be 'Shield Charm'.");
        assertEquals(0, buffSpell.damage, "Damage must be zero for a non-damaging spell.");
        assertFalse(buffSpell.skipOpponentTurn, "skipOpponentTurn must be false for a shield spell.");
        assertTrue(buffSpell.reduceNextDamage, "reduceNextDamage must be true for a shield spell.");
        assertEquals(0.8, buffSpell.damageReductionFactor, 0.001, "Damage reduction factor must be 0.8.");
    }

    // Tests Attack object creation with negative damage. Verifies behavior for an input edge case, even if healing isn't explicitly supported by Attack.
    @Test
    public void testAttackCreationNegativeDamage() {
        Attack curse = new Attack("Dementor's Kiss", -20, false, false, 1.0);

        assertEquals("Dementor's Kiss", curse.name, "Spell name must be 'Dementor's Kiss'.");
        assertEquals(-20, curse.damage, "Damage must be negative for this specific case.");
        assertFalse(curse.skipOpponentTurn, "skipOpponentTurn must be false.");
        assertFalse(curse.reduceNextDamage, "reduceNextDamage must be false.");
        assertEquals(1.0, curse.damageReductionFactor, 0.001, "Damage reduction factor must be 1.0 (no reduction).");
    }

    // Tests an attack designed to skip the opponent's turn, without damage reduction.
    @Test
    public void testAttackCreationSkipTurnOnly() {
        Attack stunSpell = new Attack("Petrificus Totalus", 30, true, false, 1.0);

        assertEquals("Petrificus Totalus", stunSpell.name, "Spell name must be 'Petrificus Totalus'.");
        assertEquals(30, stunSpell.damage, "Damage must be 30.");
        assertTrue(stunSpell.skipOpponentTurn, "skipOpponentTurn must be true for a stun spell.");
        assertFalse(stunSpell.reduceNextDamage, "reduceNextDamage must be false.");
        assertEquals(1.0, stunSpell.damageReductionFactor, 0.001, "Damage reduction factor must be 1.0 (no reduction).");
    }

    // Tests an attack providing complete damage reduction (using a factor of 0.0). Boundary test for the `damageReductionFactor` attribute.
    @Test
    public void testAttackCreationZeroDamageReductionFactor() {
        Attack perfectShield = new Attack("Impenetrable Ward", 0, false, true, 0.0);

        assertEquals("Impenetrable Ward", perfectShield.name, "Spell name must be 'Impenetrable Ward'.");
        assertEquals(0, perfectShield.damage, "Damage must be 0.");
        assertFalse(perfectShield.skipOpponentTurn, "skipOpponentTurn must be false for a shield spell.");
        assertTrue(perfectShield.reduceNextDamage, "reduceNextDamage must be true for a shield spell.");
        assertEquals(0.0, perfectShield.damageReductionFactor, 0.001, "Damage reduction factor must be 0.0 (complete reduction).");
    }

    // Tests the `toString()` method for correct string representation.
    @Test
    public void testToString() {
        Attack spell = new Attack("Fireball", 75, false, false, 1.0);
        assertEquals("Fireball (Damage: 75)", spell.toString(), "toString() method must return the expected format.");
    }
}

public class CharacterStatsTest {

    // Tests CharacterStats constructor and getter methods for standard positive values.
    @Test
    public void testCharacterStatsCreationStandard() {
        CharacterStats stats = new CharacterStats(10, 8, 12, 5);

        assertEquals(10, stats.getStrength(), "Strength must be 10.");
        assertEquals(8, stats.getIntelligence(), "Intelligence must be 8.");
        assertEquals(12, stats.getDefence(), "Defence must be 12.");
        assertEquals(5, stats.getInitiative(), "Initiative must be 5.");
    }

    // Tests CharacterStats creation with zero values for all stats. Boundary case.
    @Test
    public void testCharacterStatsCreationZeros() {
        CharacterStats stats = new CharacterStats(0, 0, 0, 0);

        assertEquals(0, stats.getStrength(), "Strength must be 0.");
        assertEquals(0, stats.getIntelligence(), "Intelligence must be 0.");
        assertEquals(0, stats.getDefence(), "Defence must be 0.");
        assertEquals(0, stats.getInitiative(), "Initiative must be 0.");
    }

    // Tests CharacterStats creation with negative values. This checks input handling.
    @Test
    public void testCharacterStatsCreationNegative() {
        CharacterStats stats = new CharacterStats(-5, -2, -1, -10);

        assertEquals(-5, stats.getStrength(), "Strength must be -5.");
        assertEquals(-2, stats.getIntelligence(), "Intelligence must be -2.");
        assertEquals(-1, stats.getDefence(), "Defence must be -1.");
        assertEquals(-10, stats.getInitiative(), "Initiative must be -10.");
    }

    // Tests setter methods for updating individual stats.
    @Test
    public void testSetters() {
        CharacterStats stats = new CharacterStats(10, 10, 10, 10);

        stats.setStrength(15);
        assertEquals(15, stats.getStrength(), "Strength must be updated to 15.");

        stats.setIntelligence(7);
        assertEquals(7, stats.getIntelligence(), "Intelligence must be updated to 7.");

        stats.setDefence(20);
        assertEquals(20, stats.getDefence(), "Defence must be updated to 20.");

        stats.setInitiative(1);
        assertEquals(1, stats.getInitiative(), "Initiative must be updated to 1.");
    }
}
