# Shipment-CIF-Management-System

**GROUP WORK OF 2 PROJECT**

Dieses Projekt ist ein Java-basiertes Versandverwaltungssystem, das es Benutzern ermöglicht, Kundeninformationen zu verwalten, verschiedene Versandarten hinzuzufügen, Bestellungen zu erstellen und Rechnungen anzuzeigen. Es kombiniert eine konsolenbasierte Benutzeroberfläche mit einer grafischen Komponente, um eine funktionale und benutzerfreundliche Anwendung zu bieten.

Kundenverwaltung:
Das System erlaubt das Erfassen und Speichern von Kundendaten wie ID, Vorname, Nachname und Telefonnummer. Die Eingaben werden validiert, um sicherzustellen, dass sie einem festgelegten Format entsprechen. Die Telefonnummer wird in Kombination mit einem international wählbaren Ländervorwahl-Code gespeichert (z. B. +49 für Deutschland, +961 für Libanon).

Versandarten:
Der Benutzer kann zwischen drei Versandarten wählen – Luftfracht, Landfracht und Seefracht. Jede Versandart enthält spezifische Informationen wie Ursprungsland, Zielland, Ursprungshafen, Zielhafen und Anzahl der Pakete. Die Versandkosten werden je nach Versandtyp berechnet (Logik befindet sich vermutlich in weiteren Klassen).

Bestellungsverwaltung:
Der Benutzer kann eine Bestellung erstellen, indem er einen bestehenden Kunden mit einem Versanddatensatz kombiniert. Die Anwendung unterstützt das Anzeigen aller Kunden, Versandarten und Bestellungen sowie das Löschen von Bestellungen.

Rechnungserstellung (GUI):
Ein besonderes Feature ist die Möglichkeit, für jede Bestellung eine Rechnung als grafisches Fenster (JFrame) anzuzeigen. Die Rechnung enthält alle relevanten Informationen wie Bestell-ID, Kundenname, Versandart, Kosten und Versanddetails. Ein „Drucken“-Button simuliert das Ausdrucken der Rechnung.

Fazit:
Das Projekt stellt eine solide Grundlage für ein umfassendes Versandmanagementsystem dar. Es bietet klare Eingabestrukturen, einfache Navigation durch ein Menüsystem und eine anschauliche Rechnungsanzeige mit grafischer Benutzeroberfläche. Ideal geeignet als Lernprojekt oder Basis für größere Geschäftsanwendungen.
