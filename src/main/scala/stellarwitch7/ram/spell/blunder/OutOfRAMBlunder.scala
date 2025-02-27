package stellarwitch7.ram.spell.blunder

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.blunder.TrickBlunderException
import net.minecraft.text.MutableText

class OutOfRAMBlunder(source: Trick) extends TrickBlunderException(source) {
  override def createMessage(): MutableText =
    super.createMessage().append("Cannot allocate any Random Access Mind slot as none are free")
}
