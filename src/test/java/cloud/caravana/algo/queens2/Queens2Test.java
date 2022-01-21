package cloud.caravana.algo.queens2;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Queens2Test {
    @Test
    void case0() {
        var result = Queens2.queensAttack(
                4, 0,
                4, 4,
                of());
        assertEquals(9, result);
    }

    @Test
    void case1() {
        var result = Queens2.queensAttack(
                5, 3,
                4, 3,
                of(
                    of(5, 5),
                    of(4, 2),
                    of(2, 3)));
        assertEquals(10, result);
    }

    @Test
    void case7() {
        var result = Queens2.queensAttack(
                100, 100,
                54, 30,
                of(
                    of(48, 36),
                    of(38, 46),
                    of(60, 24),
                    of(70, 14),
                    of(54, 36),
                    of(54, 24),
                    of(60, 30),
                    of(48, 30),
                    of(71, 50),
                    of(14, 97),
                    of(47, 31),
                    of(29, 68),
                    of(90, 10),
                    of(36, 85),
                    of(63, 24),
                    of(32, 13),
                    of(64, 57),
                    of(45, 57),
                    of(86, 19),
                    of(43, 86),
                    of(68, 72),
                    of(29, 25),
                    of(48, 59),
                    of(38, 78),
                    of(45, 16),
                    of(40, 92),
                    of(76, 85),
                    of(40, 10),
                    of(65, 16),
                    of(71, 18),
                    of(90, 40),
                    of(65, 45),
                    of(10, 37),
                    of(19, 82),
                    of(42, 56),
                    of(46, 60),
                    of(94, 14),
                    of(34, 36),
                    of(95, 49),
                    of(78, 67),
                    of(86, 23),
                    of(28, 12),
                    of(95, 57),
                    of(38, 19),
                    of(61, 49),
                    of(67, 42),
                    of(28, 25),
                    of(38, 28),
                    of(91, 20),
                    of(90, 86),
                    of(81, 19),
                    of(18, 43),
                    of(29, 69),
                    of(36, 20),
                    of(72, 75),
                    of(39, 50),
                    of(17, 92),
                    of(48, 25),
                    of(20, 79),
                    of(82, 57),
                    of(58, 50),
                    of(94, 70),
                    of(17, 19),
                    of(73, 20),
                    of(45, 12),
                    of(19, 89),
                    of(45, 12),
                    of(59, 74),
                    of(63, 71),
                    of(32, 23),
                    of(67, 85),
                    of(24, 25),
                    of(18, 61),
                    of(97, 50),
                    of(70, 37),
                    of(30, 10),
                    of(39, 90),
                    of(75, 58),
                    of(58, 34),
                    of(47, 62),
                    of(28, 28),
                    of(79, 34),
                    of(73, 80),
                    of(93, 36),
                    of(25, 45),
                    of(48, 75),
                    of(42, 13),
                    of(18, 69),
                    of(35, 21),
                    of(18, 87),
                    of(57, 19),
                    of(26, 92),
                    of(94, 34),
                    of(84, 48),
                    of(61, 95),
                    of(62, 89),
                    of(59, 74),
                    of(50, 40),
                    of(36, 37),
                    of(95, 62)));
        assertEquals(62, result);
    }
}
