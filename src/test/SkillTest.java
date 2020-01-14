package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Skill;

class SkillTest {

	@Test
	void testSkillEmptyConstructor() {
		Skill sk = new Skill();
			assertNotNull(sk);
	}

	@Test
	void testGetId() {
		Skill sk = new Skill(1, "", 1, "");
		assertEquals(1, sk.getId());
	}

	@Test
	void testSetId() {
		Skill sk = new Skill(1, "", 1, "");
			sk.setId(2);
			assertEquals(2, sk.getId());
	}

	@Test
	void testGetNome() {
		Skill sk = new Skill(1, "java", 1, "");
			assertEquals("java", sk.getNome());
	}

	@Test
	void testSetNome() {
		Skill sk = new Skill(1, "java", 1, "");
			sk.setNome("c");
			assertEquals("c", sk.getNome());
	}

	@Test
	void testGetTipo() {
		Skill sk = new Skill (1, "", 1, "");
			assertEquals(1, sk.getTipo());
	}

	@Test
	void testSetTipo() {
		Skill sk = new Skill (1, "", 1, "");
			sk.setTipo(2);
			assertEquals(2, sk.getTipo());
	}

	@Test
	void testGetLvl() {
		Skill sk = new Skill (1, "", 1, "a");
			assertEquals("a", sk.getLvl());
	}

	@Test
	void testSetLvl() {
		Skill sk = new Skill (1, "", 1, "a");
			sk.setLvl("b");
			assertEquals("b", sk.getLvl());
	}

}
