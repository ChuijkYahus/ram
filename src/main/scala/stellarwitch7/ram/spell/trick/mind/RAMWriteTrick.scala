package stellarwitch7.ram.spell.trick.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.fragment.VoidFragment
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.cca.entity.ModEntityComponents
import stellarwitch7.ram.spell.blunder.RAMNotSupportedBlunder
import scala.collection.JavaConverters._

class RAMWriteTrick extends Trick(Pattern.of(1, 4, 5, 8, 6, 3)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment = {
    val number = expectInput(fragments, FragmentType.NUMBER, 0).asInt()
    val any = expectInput(fragments, 1)

    ctx.source.getComponent(ModEntityComponents.ram).orElseThrow(() =>
      RAMNotSupportedBlunder(this)
    ).ram.write(this, number, any)

    any
  }
}
