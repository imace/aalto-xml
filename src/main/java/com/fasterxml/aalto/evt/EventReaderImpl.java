/*
 * Copyright (c) 2006- Tatu Saloranta, tatu.saloranta@iki.fi
 *
 * Licensed under the License specified in the file LICENSE which is
 * included with the source code.
 * You may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fasterxml.aalto.evt;

import javax.xml.stream.*;
import javax.xml.stream.util.XMLEventAllocator;

import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2EventReaderImpl;

import com.fasterxml.aalto.impl.StreamExceptionBase;

/**
 * Simple implementation based on Stax2 reference implementation
 * base.
 */
public final class EventReaderImpl
    extends Stax2EventReaderImpl
{
    public EventReaderImpl(XMLEventAllocator a, XMLStreamReader2 r)
    {
        super(a, r);
    }

    /*
    //////////////////////////////////////////////////////
    // Impl of abstract methods
    //////////////////////////////////////////////////////
     */

    protected String getErrorDesc(int errorType, int currEvent)
    {
        // For now, defaults are ok, can improve as necessary
        return null;
    }

    public boolean isPropertySupported(String name)
    {
        return ((XMLStreamReader2)getStreamReader()).isPropertySupported(name);
    }

    public boolean setProperty(String name, Object value)
    {
        return ((XMLStreamReader2)getStreamReader()).setProperty(name, value);
    }

    /*
    //////////////////////////////////////////////////////
    // Overrides
    //////////////////////////////////////////////////////
     */

    // @Override
    protected void reportProblem(String msg, Location loc)
        throws XMLStreamException
    {
        /* Should probably have a specific exception for Writer
         * side? For now, let's at least use base class we
         * control, which gives slightly better output.
         */
        throw new StreamExceptionBase(msg, loc);
    }
}
