package org.rust.ide.structure

import com.intellij.ide.structureView.StructureViewBuilder
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import org.rust.lang.core.psi.impl.RustFile

class RustPsiStructureViewFactory: PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile?): StructureViewBuilder {
        val rustFile = psiFile as RustFile;
        return object: TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return RustStructureViewModel(editor, rustFile)
            }
        }
    }
}
