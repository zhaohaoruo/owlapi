/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.coode.owlapi.rdfxml.parser;

import static org.semanticweb.owlapi.vocab.OWLRDFVocabulary.*;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

/** @author Matthew Horridge, The University of Manchester, Bio-Health Informatics
 *         Group, Date: 19/12/2010 */
public class ObjectQualifiedCardinalityTranslator extends
        AbstractClassExpressionTranslator {
    /** @param consumer
     *            consumer */
    public ObjectQualifiedCardinalityTranslator(OWLRDFConsumer consumer) {
        super(consumer);
    }

    @Override
    public boolean matchesStrict(IRI mainNode) {
        return isRestrictionStrict(mainNode)
                && isNonNegativeIntegerStrict(mainNode, OWL_QUALIFIED_CARDINALITY)
                && isObjectPropertyStrict(mainNode, OWL_ON_PROPERTY)
                && isClassExpressionStrict(mainNode, OWL_ON_CLASS);
    }

    @Override
    public boolean matchesLax(IRI mainNode) {
        return isNonNegativeIntegerLax(mainNode, OWL_QUALIFIED_CARDINALITY)
                && isObjectPropertyLax(mainNode, OWL_ON_PROPERTY)
                && isClassExpressionLax(mainNode, OWL_ON_CLASS);
    }

    @Override
    public OWLObjectExactCardinality translate(IRI mainNode) {
        int cardi = translateInteger(mainNode, OWL_QUALIFIED_CARDINALITY);
        IRI propertyIRI = getConsumer()
                .getResourceObject(mainNode, OWL_ON_PROPERTY, true);
        OWLObjectPropertyExpression property = getConsumer()
                .translateObjectPropertyExpression(propertyIRI);
        IRI fillerIRI = getConsumer().getResourceObject(mainNode, OWL_ON_CLASS, true);
        OWLClassExpression filler = getConsumer().translateClassExpression(fillerIRI);
        return getDataFactory().getOWLObjectExactCardinality(cardi, property, filler);
    }
}
