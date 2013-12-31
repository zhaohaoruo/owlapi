/* Generated By:JavaCC: Do not edit this line. JavaCharStream.java Version 5.0 */
/* JavaCCOptions:STATIC=false,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package de.uulm.ecs.ai.owlapi.krssparser;

import java.io.UnsupportedEncodingException;

/** Wrapper for the common JavaCharStream for all parsers. This is needed because
 * we have a request to support UTF-8 files that have an initial BOM. UTF-8 does
 * not need BOMs but some tools insist adding them. Java on the other hand won't
 * support it, and JavaCC does not have an override for this. The result is that
 * the support must be added by hand, and it's easier to have it in one place.
 * This stops JavaCC from rebuilding the wrong files and minimizes duplicated
 * code. */
public class JavaCharStream extends uk.ac.manchester.cs.BOMSafeJavaCharStream {
    /** Constructor.
     * 
     * @param dstream
     *            stream
     * @param startline
     *            start line
     * @param startcolumn
     *            start column */
    public JavaCharStream(java.io.Reader dstream, int startline, int startcolumn) {
        super(dstream, startline, startcolumn, 4096);
    }

    /** Constructor.
     * 
     * @param dstream
     *            stream
     * @param encoding
     *            encoding
     * @param startline
     *            start line
     * @param startcolumn
     *            start column
     * @throws UnsupportedEncodingException
     *             for unsupported encoding */
    public JavaCharStream(java.io.InputStream dstream, String encoding, int startline,
            int startcolumn) throws UnsupportedEncodingException {
        super(dstream, encoding, startline, startcolumn, 4096);
    }
}
/*
 * JavaCC - OriginalChecksum=4ad82df7d3c3133e4db4b9827e23f663 (do not edit this
 * line)
 */
