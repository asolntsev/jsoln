package com.bldrei.jsoln.simplesingleparam;

import com.bldrei.jsoln.AbstractTest;
import com.bldrei.jsoln.Jsoln;
import com.bldrei.jsoln.exception.MissingValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SingleParamTest extends AbstractTest {

  @Test
  void deserialize_happyCase_success() {
    SingleRequiredParamDto dto = new Jsoln().deserialize("""
      {"requiredString":"12a "}""", SingleRequiredParamDto.class);

    assertNotNull(dto);
    assertEquals("12a ", dto.requiredString());
  }

  @Test
  void deserialize_spacesBetween_success() {
    SingleRequiredParamDto dto = new Jsoln().deserialize("""
      { \t "requiredString" \n:  "12a " \n\t  }""", SingleRequiredParamDto.class);

    assertNotNull(dto);
    assertEquals("12a ", dto.requiredString());
  }

  @Test
  void deserialize_prettyPrinted_success() {
    SingleRequiredParamDto dto = new Jsoln().deserialize("""
      {
        "requiredString": "12a "
      }""", SingleRequiredParamDto.class);

    assertNotNull(dto);
    assertEquals("12a ", dto.requiredString());
  }

  @Test
  void deserialize_requiredValueNotPresent_exception() {
    shouldThrow(MissingValueException.class,
      () -> new Jsoln().deserialize("""
        {"someOtherKey":"12a "}""", SingleRequiredParamDto.class),
      "Value not present, but field 'requiredString' is mandatory on dto class com.bldrei.jsoln.simplesingleparam.SingleRequiredParamDto");
  }
}

