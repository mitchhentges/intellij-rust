package org.rust.lang.core.parser

import com.intellij.psi.PsiFile
import org.assertj.core.api.Assertions.assertThat

class RustPartialParsingTestCase : RustParsingTestCaseBase("partial") {

    fun testFn() = doTest(true)
    fun testUseItem() = doTest(true)
    fun testShifts() = doTest(true)
    fun testStructPat() = doTest(true)
    fun testStructDef() = doTest(true)
    fun testIfExpr() = doTest(true)
    fun testEnumVis() = doTest(true)
    fun testImplBody() = doTest(true)

    override fun checkResult(targetDataName: String?, file: PsiFile?) {
        checkHasError(file)
        super.checkResult(targetDataName, file)
    }

    private fun checkHasError(file: PsiFile?) {
        assertThat(hasError(file!!))
            .withFailMessage("Invalid file was parsed successfully: ${file.name}")
            .isTrue()
    }
}
