package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRolenameIsTeam() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("team");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsTeam() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        store.add(new Role("1", "developer"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("team");
    }

    @Test
    void whenReplaceThenRolenameIsDeveloper() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        store.replace("1", new Role("1", "developer"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("developer");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        store.replace("10", new Role("10", "developer"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("team");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRolenameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("team");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        boolean rsl = store.replace("1", new Role("1", "developer"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        boolean rsl = store.replace("10", new Role("10", "developer"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "team"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}