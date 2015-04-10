package com.frost.forest.pen.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
* Created by wenkui on 2015/4/7.
* <p>
    * Character information is based on the Unicode Standard, version 6.2.0.
    * <p>
    *
<ul>
    *
    <li><a href="http://www.unicode.org">http://www.unicode.org</a>
        *
</ul>
*/
public enum EasyUnicode {


MANDAIC,
MALAYALAM,
CARIAN,
YI,
BRAHMI,
TAI_LE,
MYANMAR,
BALINESE,
HANGUL,
INSCRIPTIONAL_PARTHIAN,
TAMIL,
BATAK,
ARABIC,
EGYPTIAN_HIEROGLYPHS,
NEW_TAI_LUE,
OLD_TURKIC,
THAANA,
LINEAR_B,
IMPERIAL_ARAMAIC,
HANUNOO,
ORIYA,
OLD_PERSIAN,
NKO,
CUNEIFORM,
KATAKANA,
COMMON,
REJANG,
BENGALI,
SHARADA,
SINHALA,
CYRILLIC,
CHAKMA,
CHAM,
SYRIAC,
OSMANYA,
CYPRIOT,
CHEROKEE,
COPTIC,
SYLOTI_NAGRI,
PHAGS_PA,
HIRAGANA,
PHOENICIAN,
UGARITIC,
DEVANAGARI,
JAVANESE,
RUNIC,
TELUGU,
ARMENIAN,
KAITHI,
HAN,
CANADIAN_ABORIGINAL,
GURMUKHI,
LAO,
KHMER,
LEPCHA,
TAKRI,
KHAROSHTHI,
INSCRIPTIONAL_PAHLAVI,
LIMBU,
SHAVIAN,
OLD_SOUTH_ARABIAN,
LYCIAN,
DESERET,
GEORGIAN,
LATIN,
SUNDANESE,
KAYAH_LI,
BRAILLE,
MEETEI_MAYEK,
HEBREW,
THAI,
GLAGOLITIC,
LISU,
TAGALOG,
OL_CHIKI,
BAMUM,
TAI_THAM,
SAURASHTRA,
TAI_VIET,
LYDIAN,
MEROITIC_CURSIVE,
SORA_SOMPENG,
TIBETAN,
AVESTAN,
GOTHIC,
OLD_ITALIC,
MONGOLIAN,
SAMARITAN,
KANNADA,
OGHAM,
ETHIOPIC,
TIFINAGH,
GUJARATI,
MEROITIC_HIEROGLYPHS,
BOPOMOFO,
BUGINESE,
MIAO,
GREEK,
BUHID,
UNKNOWN,
INHERITED,
TAGBANWA,
VAI,
tai_viet,
gurmukhi,
ugaritic,
coptic,
greek_and_coptic,
latin_extended_a,
latin_extended_b,
kannada,
ideographic_description_characters,
general_punctuation,
devanagari,
lydian,
linear_b_ideograms,
latin_extended_c,
latin_extended_d,
tags,
ethiopic_extended,
miscellaneous_symbols_and_pictographs,
cyrillic,
cherokee,
currency_symbols,
armenian,
tai_xuan_jing_symbols,
ancient_symbols,
gujarati,
lepcha,
old_south_arabian,
kangxi_radicals,
specials,
miscellaneous_mathematical_symbols_b,
sundanese,
kanbun,
cjk_symbols_and_punctuation,
cuneiform_numbers_and_punctuation,
miscellaneous_mathematical_symbols_a,
greek_extended,
cjk_compatibility_ideographs_supplement,
samaritan,
nko,
bopomofo,
kaithi,
cjk_strokes,
linear_b_syllabary,
sundanese_supplement,
alphabetic_presentation_forms,
meroitic_cursive,
tamil,
mathematical_operators,
miscellaneous_symbols,
geometric_shapes,
ethiopic_supplement,
musical_symbols,
myanmar_extended_a,
runic,
saurashtra,
myanmar,
optical_character_recognition,
cypriot_syllabary,
old_turkic,
counting_rod_numerals,
phonetic_extensions_supplement,
superscripts_and_subscripts,
miscellaneous_technical,
low_surrogates,
lisu,
supplemental_mathematical_operators,
syriac,
enclosed_ideographic_supplement,
limbu,
hanunoo,
cjk_compatibility_forms,
variation_selectors_supplement,
meetei_mayek_extensions,
cjk_compatibility_ideographs,
alchemical_symbols,
javanese,
ethiopic_extended_a,
ipa_extensions,
oriya,
ancient_greek_musical_notation,
kharoshthi,
aegean_numbers,
lycian,
bamum,
arrows,
miao,
hiragana,
dingbats,
sharada,
katakana_phonetic_extensions,
new_tai_lue,
hangul_syllables,
enclosed_alphanumerics,
miscellaneous_symbols_and_arrows,
domino_tiles,
mahjong_tiles,
control_pictures,
kayah_li,
egyptian_hieroglyphs,
hangul_compatibility_jamo,
mathematical_alphanumeric_symbols,
old_persian,
gothic,
latin___supplement,
sinhala,
block_elements,
takri,
vai,
high_private_use_surrogates,
kana_supplement,
vertical_forms,
hebrew,
hangul_jamo,
shavian,
mongolian,
deseret,
tai_tham,
syloti_nagri,
batak,
ogham,
basic_latin,
enclosed_cjk_letters_and_months,
variation_selectors,
number_forms,
halfwidth_and_fullwidth_forms,
yi_syllables,
unified_canadian_aboriginal_syllabics_extended,
osmanya,
cyrillic_extended_a,
cyrillic_extended_b,
meroitic_hieroglyphs,
transport_and_map_symbols,
bengali,
byzantine_musical_symbols,
bopomofo_extended,
glagolitic,
ancient_greek_numbers,
phags_pa,
private_use_area,
combining_diacritical_marks_for_symbols,
inscriptional_pahlavi,
bamum_supplement,
tibetan,
cham,
telugu,
enclosed_alphanumeric_supplement,
yi_radicals,
tagalog,
letterlike_symbols,
thaana,
georgian,
buginese,
phoenician,
vedic_extensions,
brahmi,
playing_cards,
malayalam,
hangul_jamo_extended_a,
hangul_jamo_extended_b,
rumi_numeral_symbols,
cyrillic_supplement,
avestan,
khmer,
modifier_tone_letters,
inscriptional_parthian,
supplemental_arrows_a,
chakma,
phaistos_disc,
supplemental_arrows_b,
lao,
latin_extended_additional,
phonetic_extensions,
emoticons,
khmer_symbols,
yijing_hexagram_symbols,
imperial_aramaic,
unassigned,
small_form_variants,
devanagari_extended,
cjk_unified_ideographs,
arabic,
mandaic,
cuneiform,
old_italic,
thai,
supplemental_punctuation,
cjk_radicals_supplement,
tagbanwa,
rejang,
cjk_unified_ideographs_extension_c,
cjk_unified_ideographs_extension_d,
cjk_unified_ideographs_extension_a,
tifinagh,
cjk_unified_ideographs_extension_b,
braille_patterns,
cjk_compatibility,
ol_chiki,
ethiopic,
arabic_extended_a,
katakana,
common_indic_number_forms,
carian,
meetei_mayek,
unified_canadian_aboriginal_syllabics,
high_surrogates,
arabic_presentation_forms_a,
combining_half_marks,
box_drawing,
combining_diacritical_marks,
spacing_modifier_letters,
tai_le,
buhid,
arabic_mathematical_alphabetic_symbols,
georgian_supplement,
arabic_presentation_forms_b,
supplementary_private_use_area_b,
combining_diacritical_marks_supplement,
balinese,
supplementary_private_use_area_a,
sora_sompeng,
arabic_supplement;


private static final Map
<EasyUnicode, String> UnitsMap = new HashMap
<EasyUnicode, String>();

static {
/*UnicodeScripts */
UnitsMap.put(ARABIC,"[\u0600-\u060B\u060D-\u061A\u061E-\u061E\u0620-\u063F\u0641-\u064A\u0656-\u065F\u066A-\u066F\u0671-\u06DC\u06DE-\u06FF\u0750-\u077F\u08A0-\u08FF\uFB50-\uFD3D\uFD50-\uFDFC\uFE70-\uFEFE\uD803\uDE60-\uD803\uDFFF\uD83B\uDE00-\uD83B\uDFFF]");
UnitsMap.put(ARMENIAN,"[\u0531-\u0588\u058A-\u0590\uFB13-\uFB1C]");
UnitsMap.put(AVESTAN,"[\uD802\uDF00-\uD802\uDF3F]");
UnitsMap.put(BALINESE,"[\u1B00-\u1B7F]");
UnitsMap.put(BAMUM,"[\uA6A0-\uA6FF\uD81A\uDC00-\uD81A\uDE38]");
UnitsMap.put(BATAK,"[\u1BC0-\u1BFF]");
UnitsMap.put(BENGALI,"[\u0981-\u0A00]");
UnitsMap.put(BOPOMOFO,"[\u02EA-\u02EB\u3105-\u3130\u31A0-\u31BF]");
UnitsMap.put(BRAHMI,"[\uD804\uDC00-\uD804\uDC7F]");
UnitsMap.put(BRAILLE,"[\u2800-\u28FF]");
UnitsMap.put(BUGINESE,"[\u1A00-\u1A1F]");
UnitsMap.put(BUHID,"[\u1740-\u175F]");
UnitsMap.put(CANADIAN_ABORIGINAL,"[\u1400-\u167F\u18B0-\u18FF]");
UnitsMap.put(CARIAN,"[\uD800\uDEA0-\uD800\uDEFF]");
UnitsMap.put(CHAKMA,"[\uD804\uDD00-\uD804\uDD7F]");
UnitsMap.put(CHAM,"[\uAA00-\uAA5F]");
UnitsMap.put(CHEROKEE,"[\u13A0-\u13FF]");
UnitsMap.put(COMMON,"[\u0000-\u0040\u005B-\u0060\u007B-\u00A9\u00AB-\u00B9\u00BB-\u00BF\u00D7-\u00D7\u00F7-\u00F7\u02B9-\u02DF\u02E5-\u02E9\u02EC-\u02FF\u0374-\u0374\u037E-\u0383\u0385-\u0385\u0387-\u0387\u0589-\u0589\u060C-\u060C\u061B-\u061D\u061F-\u061F\u0640-\u0640\u0660-\u0669\u06DD-\u06DD\u0964-\u0965\u0E3F-\u0E3F\u0FD5-\u0FD8\u10FB-\u10FB\u16EB-\u16ED\u1735-\u173F\u1802-\u1803\u1805-\u1805\u1CD3-\u1CD3\u1CE1-\u1CE1\u1CE9-\u1CEC\u1CEE-\u1CF3\u1CF5-\u1CFF\u2000-\u200B\u200E-\u2070\u2074-\u207E\u2080-\u208F\u20A0-\u20CF\u2100-\u2125\u2127-\u2129\u212C-\u2131\u2133-\u214D\u214F-\u215F\u2189-\u27FF\u2900-\u2BFF\u2E00-\u2E7F\u2FF0-\u3004\u3006-\u3006\u3008-\u3020\u3030-\u3037\u303C-\u3040\u309B-\u309C\u30A0-\u30A0\u30FB-\u30FC\u3190-\u319F\u31C0-\u31EF\u3220-\u325F\u327F-\u32CF\u3358-\u33FF\u4DC0-\u4DFF\uA700-\uA721\uA788-\uA78A\uA830-\uA83F\uFD3E-\uFD4F\uFDFD-\uFDFF\uFE10-\uFE1F\uFE30-\uFE6F\uFEFF-\uFF20\uFF3B-\uFF40\uFF5B-\uFF65\uFF70-\uFF70\uFF9E-\uFF9F\uFFE0-\uFFFF\uD800\uDD00-\uD800\uDD3F\uD800\uDD90-\uD800\uDDFC\uD834\uDC00-\uD834\uDD66\uD834\uDD6A-\uD834\uDD7A\uD834\uDD83-\uD834\uDD84\uD834\uDD8C-\uD834\uDDA9\uD834\uDDAE-\uD834\uDDFF\uD834\uDF00-\uD83B\uDDFF\uD83C\uDC00-\uD83C\uDDFF\uD83C\uDE10-\uD83F\uDFFF\uDB40\uDC01-\uDB40\uDCFF]");
UnitsMap.put(COPTIC,"[\u03E2-\u03EF\u2C80-\u2CFF]");
UnitsMap.put(CUNEIFORM,"[\uD808\uDC00-\uD80B\uDFFF]");
UnitsMap.put(CYPRIOT,"[\uD802\uDC00-\uD802\uDC3F]");
UnitsMap.put(CYRILLIC,"[\u0400-\u0484\u0487-\u0530\u1D2B-\u1D2B\u1D78-\u1D78\u2DE0-\u2DFF\uA640-\uA69F]");
UnitsMap.put(DESERET,"[\uD801\uDC00-\uD801\uDC4F]");
UnitsMap.put(DEVANAGARI,"[\u0900-\u0950\u0953-\u0963\u0966-\u0980\uA8E0-\uA8FF]");
UnitsMap.put(EGYPTIAN_HIEROGLYPHS,"[\uD80C\uDC00-\uD819\uDFFF]");
UnitsMap.put(ETHIOPIC,"[\u1200-\u139F\u2D80-\u2DDF\uAB01-\uABBF]");
UnitsMap.put(GEORGIAN,"[\u10A0-\u10FA\u10FC-\u10FF\u2D00-\u2D2F]");
UnitsMap.put(GLAGOLITIC,"[\u2C00-\u2C5F]");
UnitsMap.put(GOTHIC,"[\uD800\uDF30-\uD800\uDF7F]");
UnitsMap.put(GREEK,"[\u0370-\u0373\u0375-\u037D\u0384-\u0384\u0386-\u0386\u0388-\u03E1\u03F0-\u03FF\u1D26-\u1D2A\u1D5D-\u1D61\u1D66-\u1D6A\u1DBF-\u1DBF\u1F00-\u1FFF\u2126-\u2126\uD800\uDD40-\uD800\uDD8F\uD834\uDE00-\uD834\uDEFF]");
UnitsMap.put(GUJARATI,"[\u0A81-\u0B00]");
UnitsMap.put(GURMUKHI,"[\u0A01-\u0A80]");
UnitsMap.put(HAN,"[\u2E80-\u2FEF\u3005-\u3005\u3007-\u3007\u3021-\u3029\u3038-\u303B\u3400-\u4DBF\u4E00-\u9FFF\uF900-\uFAFF\uD840\uDC00-\uDB40\uDC00]");
UnitsMap.put(HANGUL,"[\u1100-\u11FF\u302E-\u302F\u3131-\u318F\u3200-\u321F\u3260-\u327E\uA960-\uA97F\uAC00-\uD7FB\uFFA0-\uFFDF]");
UnitsMap.put(HANUNOO,"[\u1720-\u1734]");
UnitsMap.put(HEBREW,"[\u0591-\u05FF\uFB1D-\uFB4F]");
UnitsMap.put(HIRAGANA,"[\u3041-\u3098\u309D-\u309F\uD82C\uDC01-\uD833\uDFFF\uD83C\uDE00-\uD83C\uDE00]");
UnitsMap.put(IMPERIAL_ARAMAIC,"[\uD802\uDC40-\uD802\uDCFF]");
UnitsMap.put(INHERITED,"[\u0300-\u036F\u0485-\u0486\u064B-\u0655\u0670-\u0670\u0951-\u0952\u1CD0-\u1CD2\u1CD4-\u1CE0\u1CE2-\u1CE8\u1CED-\u1CED\u1CF4-\u1CF4\u1DC0-\u1DFF\u200C-\u200D\u20D0-\u20FF\u302A-\u302D\u3099-\u309A\uFE00-\uFE0F\uFE20-\uFE2F\uD800\uDDFD-\uD800\uDE7F\uD834\uDD67-\uD834\uDD69\uD834\uDD7B-\uD834\uDD82\uD834\uDD85-\uD834\uDD8B\uD834\uDDAA-\uD834\uDDAD\uDB40\uDD00-\uDB40\uDDEF]");
UnitsMap.put(INSCRIPTIONAL_PAHLAVI,"[\uD802\uDF60-\uD802\uDFFF]");
UnitsMap.put(INSCRIPTIONAL_PARTHIAN,"[\uD802\uDF40-\uD802\uDF5F]");
UnitsMap.put(JAVANESE,"[\uA980-\uA9FF]");
UnitsMap.put(KAITHI,"[\uD804\uDC80-\uD804\uDCCF]");
UnitsMap.put(KANNADA,"[\u0C82-\u0CF0]");
UnitsMap.put(KATAKANA,"[\u30A1-\u30FA\u30FD-\u3104\u31F0-\u31FF\u32D0-\u3357\uFF66-\uFF6F\uFF71-\uFF9D\uD82C\uDC00-\uD82C\uDC00]");
UnitsMap.put(KAYAH_LI,"[\uA900-\uA92F]");
UnitsMap.put(KHAROSHTHI,"[\uD802\uDE00-\uD802\uDE5F]");
UnitsMap.put(KHMER,"[\u1780-\u17FF\u19E0-\u19FF]");
UnitsMap.put(LAO,"[\u0E81-\u0EFF]");
UnitsMap.put(LATIN,"[\u0041-\u005A\u0061-\u007A\u00AA-\u00AA\u00BA-\u00BA\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02B8\u02E0-\u02E4\u1D00-\u1D25\u1D2C-\u1D5C\u1D62-\u1D65\u1D6B-\u1D77\u1D79-\u1DBE\u1E00-\u1EFF\u2071-\u2073\u207F-\u207F\u2090-\u209F\u212A-\u212B\u2132-\u2132\u214E-\u214E\u2160-\u2188\u2C60-\u2C7F\uA722-\uA787\uA78B-\uA7FF\uFB00-\uFB12\uFF21-\uFF3A\uFF41-\uFF5A]");
UnitsMap.put(LEPCHA,"[\u1C00-\u1C4F]");
UnitsMap.put(LIMBU,"[\u1900-\u194F]");
UnitsMap.put(LINEAR_B,"[\uD800\uDC00-\uD800\uDCFF]");
UnitsMap.put(LISU,"[\uA4D0-\uA4FF]");
UnitsMap.put(LYCIAN,"[\uD800\uDE80-\uD800\uDE9F]");
UnitsMap.put(LYDIAN,"[\uD802\uDD20-\uD802\uDD7F]");
UnitsMap.put(MALAYALAM,"[\u0D02-\u0D81]");
UnitsMap.put(MANDAIC,"[\u0840-\u089F]");
UnitsMap.put(MEETEI_MAYEK,"[\uAAE0-\uAB00\uABC0-\uABFF]");
UnitsMap.put(MEROITIC_CURSIVE,"[\uD802\uDDA0-\uD802\uDDFF]");
UnitsMap.put(MEROITIC_HIEROGLYPHS,"[\uD802\uDD80-\uD802\uDD9F]");
UnitsMap.put(MIAO,"[\uD81B\uDF00-\uD81B\uDF9F]");
UnitsMap.put(MONGOLIAN,"[\u1800-\u1801\u1804-\u1804\u1806-\u18AF]");
UnitsMap.put(MYANMAR,"[\u1000-\u109F\uAA60-\uAA7F]");
UnitsMap.put(NEW_TAI_LUE,"[\u1980-\u19DF]");
UnitsMap.put(NKO,"[\u07C0-\u07FF]");
UnitsMap.put(OGHAM,"[\u1680-\u169F]");
UnitsMap.put(OLD_ITALIC,"[\uD800\uDF00-\uD800\uDF2F]");
UnitsMap.put(OLD_PERSIAN,"[\uD800\uDFA0-\uD800\uDFFF]");
UnitsMap.put(OLD_SOUTH_ARABIAN,"[\uD802\uDE60-\uD802\uDEFF]");
UnitsMap.put(OLD_TURKIC,"[\uD803\uDC00-\uD803\uDE5F]");
UnitsMap.put(OL_CHIKI,"[\u1C50-\u1CBF]");
UnitsMap.put(ORIYA,"[\u0B01-\u0B81]");
UnitsMap.put(OSMANYA,"[\uD801\uDC80-\uD801\uDFFF]");
UnitsMap.put(PHAGS_PA,"[\uA840-\uA87F]");
UnitsMap.put(PHOENICIAN,"[\uD802\uDD00-\uD802\uDD1F]");
UnitsMap.put(REJANG,"[\uA930-\uA95F]");
UnitsMap.put(RUNIC,"[\u16A0-\u16EA\u16EE-\u16FF]");
UnitsMap.put(SAMARITAN,"[\u0800-\u083F]");
UnitsMap.put(SAURASHTRA,"[\uA880-\uA8DF]");
UnitsMap.put(SHARADA,"[\uD804\uDD80-\uD805\uDE7F]");
UnitsMap.put(SHAVIAN,"[\uD801\uDC50-\uD801\uDC7F]");
UnitsMap.put(SINHALA,"[\u0D82-\u0E00]");
UnitsMap.put(SORA_SOMPENG,"[\uD804\uDCD0-\uD804\uDCFF]");
UnitsMap.put(SUNDANESE,"[\u1B80-\u1BBF\u1CC0-\u1CCF]");
UnitsMap.put(SYLOTI_NAGRI,"[\uA800-\uA82F]");
UnitsMap.put(SYRIAC,"[\u0700-\u074F]");
UnitsMap.put(TAGALOG,"[\u1700-\u171F]");
UnitsMap.put(TAGBANWA,"[\u1760-\u177F]");
UnitsMap.put(TAI_LE,"[\u1950-\u197F]");
UnitsMap.put(TAI_THAM,"[\u1A20-\u1AFF]");
UnitsMap.put(TAI_VIET,"[\uAA80-\uAADF]");
UnitsMap.put(TAKRI,"[\uD805\uDE80-\uD805\uDECF]");
UnitsMap.put(TAMIL,"[\u0B82-\u0C00]");
UnitsMap.put(TELUGU,"[\u0C01-\u0C81]");
UnitsMap.put(THAANA,"[\u0780-\u07BF]");
UnitsMap.put(THAI,"[\u0E01-\u0E3E\u0E40-\u0E80]");
UnitsMap.put(TIBETAN,"[\u0F00-\u0FD4\u0FD9-\u0FFF]");
UnitsMap.put(TIFINAGH,"[\u2D30-\u2D7F]");
UnitsMap.put(UGARITIC,"[\uD800\uDF80-\uD800\uDF9F]");
UnitsMap.put(UNKNOWN,"[\uD7FC-\uF8FF\uDB40\uDDF0-\uDBFF\uDFFF]");
UnitsMap.put(VAI,"[\uA500-\uA63F]");
UnitsMap.put(YI,"[\uA000-\uA4CF]");
/*UnicodeBlocks */
UnitsMap.put(aegean_numbers,"[\uD800\uDD00-\uD800\uDD3F]");
UnitsMap.put(alchemical_symbols,"[\uD83D\uDF00-\uD83D\uDF7F]");
UnitsMap.put(alphabetic_presentation_forms,"[\uFB00-\uFB4F]");
UnitsMap.put(ancient_greek_musical_notation,"[\uD834\uDE00-\uD834\uDE4F]");
UnitsMap.put(ancient_greek_numbers,"[\uD800\uDD40-\uD800\uDD8F]");
UnitsMap.put(ancient_symbols,"[\uD800\uDD90-\uD800\uDDCF]");
UnitsMap.put(arabic,"[\u0600-\u06FF]");
UnitsMap.put(arabic_extended_a,"[\u08A0-\u08FF]");
UnitsMap.put(arabic_mathematical_alphabetic_symbols,"[\uD83B\uDE00-\uD83B\uDEFF]");
UnitsMap.put(arabic_presentation_forms_a,"[\uFB50-\uFDFF]");
UnitsMap.put(arabic_presentation_forms_b,"[\uFE70-\uFEFF]");
UnitsMap.put(arabic_supplement,"[\u0750-\u077F]");
UnitsMap.put(armenian,"[\u0530-\u058F]");
UnitsMap.put(arrows,"[\u2190-\u21FF]");
UnitsMap.put(avestan,"[\uD802\uDF00-\uD802\uDF3F]");
UnitsMap.put(balinese,"[\u1B00-\u1B7F]");
UnitsMap.put(bamum,"[\uA6A0-\uA6FF]");
UnitsMap.put(bamum_supplement,"[\uD81A\uDC00-\uD81A\uDE3F]");
UnitsMap.put(basic_latin,"[\u0000-\u007F]");
UnitsMap.put(batak,"[\u1BC0-\u1BFF]");
UnitsMap.put(bengali,"[\u0980-\u09FF]");
UnitsMap.put(block_elements,"[\u2580-\u259F]");
UnitsMap.put(bopomofo,"[\u3100-\u312F]");
UnitsMap.put(bopomofo_extended,"[\u31A0-\u31BF]");
UnitsMap.put(box_drawing,"[\u2500-\u257F]");
UnitsMap.put(brahmi,"[\uD804\uDC00-\uD804\uDC7F]");
UnitsMap.put(braille_patterns,"[\u2800-\u28FF]");
UnitsMap.put(buginese,"[\u1A00-\u1A1F]");
UnitsMap.put(buhid,"[\u1740-\u175F]");
UnitsMap.put(byzantine_musical_symbols,"[\uD834\uDC00-\uD834\uDCFF]");
UnitsMap.put(carian,"[\uD800\uDEA0-\uD800\uDEDF]");
UnitsMap.put(chakma,"[\uD804\uDD00-\uD804\uDD4F]");
UnitsMap.put(cham,"[\uAA00-\uAA5F]");
UnitsMap.put(cherokee,"[\u13A0-\u13FF]");
UnitsMap.put(cjk_compatibility,"[\u3300-\u33FF]");
UnitsMap.put(cjk_compatibility_forms,"[\uFE30-\uFE4F]");
UnitsMap.put(cjk_compatibility_ideographs,"[\uF900-\uFAFF]");
UnitsMap.put(cjk_compatibility_ideographs_supplement,"[\uD87E\uDC00-\uD87E\uDE1F]");
UnitsMap.put(cjk_radicals_supplement,"[\u2E80-\u2EFF]");
UnitsMap.put(cjk_strokes,"[\u31C0-\u31EF]");
UnitsMap.put(cjk_symbols_and_punctuation,"[\u3000-\u303F]");
UnitsMap.put(cjk_unified_ideographs,"[\u4E00-\u9FFF]");
UnitsMap.put(cjk_unified_ideographs_extension_a,"[\u3400-\u4DBF]");
UnitsMap.put(cjk_unified_ideographs_extension_b,"[\uD840\uDC00-\uD869\uDEDF]");
UnitsMap.put(cjk_unified_ideographs_extension_c,"[\uD869\uDF00-\uD86D\uDF3F]");
UnitsMap.put(cjk_unified_ideographs_extension_d,"[\uD86D\uDF40-\uD86E\uDC1F]");
UnitsMap.put(combining_diacritical_marks,"[\u0300-\u036F]");
UnitsMap.put(combining_diacritical_marks_for_symbols,"[\u20D0-\u20FF]");
UnitsMap.put(combining_diacritical_marks_supplement,"[\u1DC0-\u1DFF]");
UnitsMap.put(combining_half_marks,"[\uFE20-\uFE2F]");
UnitsMap.put(common_indic_number_forms,"[\uA830-\uA83F]");
UnitsMap.put(control_pictures,"[\u2400-\u243F]");
UnitsMap.put(coptic,"[\u2C80-\u2CFF]");
UnitsMap.put(counting_rod_numerals,"[\uD834\uDF60-\uD834\uDF7F]");
UnitsMap.put(cuneiform,"[\uD808\uDC00-\uD808\uDFFF]");
UnitsMap.put(cuneiform_numbers_and_punctuation,"[\uD809\uDC00-\uD809\uDC7F]");
UnitsMap.put(currency_symbols,"[\u20A0-\u20CF]");
UnitsMap.put(cypriot_syllabary,"[\uD802\uDC00-\uD802\uDC3F]");
UnitsMap.put(cyrillic,"[\u0400-\u04FF]");
UnitsMap.put(cyrillic_extended_a,"[\u2DE0-\u2DFF]");
UnitsMap.put(cyrillic_extended_b,"[\uA640-\uA69F]");
UnitsMap.put(cyrillic_supplement,"[\u0500-\u052F]");
UnitsMap.put(deseret,"[\uD801\uDC00-\uD801\uDC4F]");
UnitsMap.put(devanagari,"[\u0900-\u097F]");
UnitsMap.put(devanagari_extended,"[\uA8E0-\uA8FF]");
UnitsMap.put(dingbats,"[\u2700-\u27BF]");
UnitsMap.put(domino_tiles,"[\uD83C\uDC30-\uD83C\uDC9F]");
UnitsMap.put(egyptian_hieroglyphs,"[\uD80C\uDC00-\uD80D\uDC2F]");
UnitsMap.put(emoticons,"[\uD83D\uDE00-\uD83D\uDE4F]");
UnitsMap.put(enclosed_alphanumeric_supplement,"[\uD83C\uDD00-\uD83C\uDDFF]");
UnitsMap.put(enclosed_alphanumerics,"[\u2460-\u24FF]");
UnitsMap.put(enclosed_cjk_letters_and_months,"[\u3200-\u32FF]");
UnitsMap.put(enclosed_ideographic_supplement,"[\uD83C\uDE00-\uD83C\uDEFF]");
UnitsMap.put(ethiopic,"[\u1200-\u137F]");
UnitsMap.put(ethiopic_extended,"[\u2D80-\u2DDF]");
UnitsMap.put(ethiopic_extended_a,"[\uAB00-\uAB2F]");
UnitsMap.put(ethiopic_supplement,"[\u1380-\u139F]");
UnitsMap.put(general_punctuation,"[\u2000-\u206F]");
UnitsMap.put(geometric_shapes,"[\u25A0-\u25FF]");
UnitsMap.put(georgian,"[\u10A0-\u10FF]");
UnitsMap.put(georgian_supplement,"[\u2D00-\u2D2F]");
UnitsMap.put(glagolitic,"[\u2C00-\u2C5F]");
UnitsMap.put(gothic,"[\uD800\uDF30-\uD800\uDF4F]");
UnitsMap.put(greek_and_coptic,"[\u0370-\u03FF]");
UnitsMap.put(greek_extended,"[\u1F00-\u1FFF]");
UnitsMap.put(gujarati,"[\u0A80-\u0AFF]");
UnitsMap.put(gurmukhi,"[\u0A00-\u0A7F]");
UnitsMap.put(halfwidth_and_fullwidth_forms,"[\uFF00-\uFFEF]");
UnitsMap.put(hangul_compatibility_jamo,"[\u3130-\u318F]");
UnitsMap.put(hangul_jamo,"[\u1100-\u11FF]");
UnitsMap.put(hangul_jamo_extended_a,"[\uA960-\uA97F]");
UnitsMap.put(hangul_jamo_extended_b,"[\uD7B0-\uD7FF]");
UnitsMap.put(hangul_syllables,"[\uAC00-\uD7AF]");
UnitsMap.put(hanunoo,"[\u1720-\u173F]");
UnitsMap.put(hebrew,"[\u0590-\u05FF]");
UnitsMap.put(high_private_use_surrogates,"[\uDB80-\uDBFF]");
UnitsMap.put(high_surrogates,"[\uD800-\uDB7F]");
UnitsMap.put(hiragana,"[\u3040-\u309F]");
UnitsMap.put(ideographic_description_characters,"[\u2FF0-\u2FFF]");
UnitsMap.put(imperial_aramaic,"[\uD802\uDC40-\uD802\uDC5F]");
UnitsMap.put(inscriptional_pahlavi,"[\uD802\uDF60-\uD802\uDF7F]");
UnitsMap.put(inscriptional_parthian,"[\uD802\uDF40-\uD802\uDF5F]");
UnitsMap.put(ipa_extensions,"[\u0250-\u02AF]");
UnitsMap.put(javanese,"[\uA980-\uA9DF]");
UnitsMap.put(kaithi,"[\uD804\uDC80-\uD804\uDCCF]");
UnitsMap.put(kana_supplement,"[\uD82C\uDC00-\uD82C\uDCFF]");
UnitsMap.put(kanbun,"[\u3190-\u319F]");
UnitsMap.put(kangxi_radicals,"[\u2F00-\u2FDF]");
UnitsMap.put(kannada,"[\u0C80-\u0CFF]");
UnitsMap.put(katakana,"[\u30A0-\u30FF]");
UnitsMap.put(katakana_phonetic_extensions,"[\u31F0-\u31FF]");
UnitsMap.put(kayah_li,"[\uA900-\uA92F]");
UnitsMap.put(kharoshthi,"[\uD802\uDE00-\uD802\uDE5F]");
UnitsMap.put(khmer,"[\u1780-\u17FF]");
UnitsMap.put(khmer_symbols,"[\u19E0-\u19FF]");
UnitsMap.put(lao,"[\u0E80-\u0EFF]");
UnitsMap.put(latin___supplement,"[\u0080-\u00FF]");
UnitsMap.put(latin_extended_a,"[\u0100-\u017F]");
UnitsMap.put(latin_extended_additional,"[\u1E00-\u1EFF]");
UnitsMap.put(latin_extended_b,"[\u0180-\u024F]");
UnitsMap.put(latin_extended_c,"[\u2C60-\u2C7F]");
UnitsMap.put(latin_extended_d,"[\uA720-\uA7FF]");
UnitsMap.put(lepcha,"[\u1C00-\u1C4F]");
UnitsMap.put(letterlike_symbols,"[\u2100-\u214F]");
UnitsMap.put(limbu,"[\u1900-\u194F]");
UnitsMap.put(linear_b_ideograms,"[\uD800\uDC80-\uD800\uDCFF]");
UnitsMap.put(linear_b_syllabary,"[\uD800\uDC00-\uD800\uDC7F]");
UnitsMap.put(lisu,"[\uA4D0-\uA4FF]");
UnitsMap.put(low_surrogates,"[\uDC00-\uDFFF]");
UnitsMap.put(lycian,"[\uD800\uDE80-\uD800\uDE9F]");
UnitsMap.put(lydian,"[\uD802\uDD20-\uD802\uDD3F]");
UnitsMap.put(mahjong_tiles,"[\uD83C\uDC00-\uD83C\uDC2F]");
UnitsMap.put(malayalam,"[\u0D00-\u0D7F]");
UnitsMap.put(mandaic,"[\u0840-\u085F]");
UnitsMap.put(mathematical_alphanumeric_symbols,"[\uD835\uDC00-\uD835\uDFFF]");
UnitsMap.put(mathematical_operators,"[\u2200-\u22FF]");
UnitsMap.put(meetei_mayek,"[\uABC0-\uABFF]");
UnitsMap.put(meetei_mayek_extensions,"[\uAAE0-\uAAFF]");
UnitsMap.put(meroitic_cursive,"[\uD802\uDDA0-\uD802\uDDFF]");
UnitsMap.put(meroitic_hieroglyphs,"[\uD802\uDD80-\uD802\uDD9F]");
UnitsMap.put(miao,"[\uD81B\uDF00-\uD81B\uDF9F]");
UnitsMap.put(miscellaneous_mathematical_symbols_a,"[\u27C0-\u27EF]");
UnitsMap.put(miscellaneous_mathematical_symbols_b,"[\u2980-\u29FF]");
UnitsMap.put(miscellaneous_symbols,"[\u2600-\u26FF]");
UnitsMap.put(miscellaneous_symbols_and_arrows,"[\u2B00-\u2BFF]");
UnitsMap.put(miscellaneous_symbols_and_pictographs,"[\uD83C\uDF00-\uD83D\uDDFF]");
UnitsMap.put(miscellaneous_technical,"[\u2300-\u23FF]");
UnitsMap.put(modifier_tone_letters,"[\uA700-\uA71F]");
UnitsMap.put(mongolian,"[\u1800-\u18AF]");
UnitsMap.put(musical_symbols,"[\uD834\uDD00-\uD834\uDDFF]");
UnitsMap.put(myanmar,"[\u1000-\u109F]");
UnitsMap.put(myanmar_extended_a,"[\uAA60-\uAA7F]");
UnitsMap.put(new_tai_lue,"[\u1980-\u19DF]");
UnitsMap.put(nko,"[\u07C0-\u07FF]");
UnitsMap.put(number_forms,"[\u2150-\u218F]");
UnitsMap.put(ogham,"[\u1680-\u169F]");
UnitsMap.put(ol_chiki,"[\u1C50-\u1C7F]");
UnitsMap.put(old_italic,"[\uD800\uDF00-\uD800\uDF2F]");
UnitsMap.put(old_persian,"[\uD800\uDFA0-\uD800\uDFDF]");
UnitsMap.put(old_south_arabian,"[\uD802\uDE60-\uD802\uDE7F]");
UnitsMap.put(old_turkic,"[\uD803\uDC00-\uD803\uDC4F]");
UnitsMap.put(optical_character_recognition,"[\u2440-\u245F]");
UnitsMap.put(oriya,"[\u0B00-\u0B7F]");
UnitsMap.put(osmanya,"[\uD801\uDC80-\uD801\uDCAF]");
UnitsMap.put(phags_pa,"[\uA840-\uA87F]");
UnitsMap.put(phaistos_disc,"[\uD800\uDDD0-\uD800\uDDFF]");
UnitsMap.put(phoenician,"[\uD802\uDD00-\uD802\uDD1F]");
UnitsMap.put(phonetic_extensions,"[\u1D00-\u1D7F]");
UnitsMap.put(phonetic_extensions_supplement,"[\u1D80-\u1DBF]");
UnitsMap.put(playing_cards,"[\uD83C\uDCA0-\uD83C\uDCFF]");
UnitsMap.put(private_use_area,"[\uE000-\uF8FF]");
UnitsMap.put(rejang,"[\uA930-\uA95F]");
UnitsMap.put(rumi_numeral_symbols,"[\uD803\uDE60-\uD803\uDE7F]");
UnitsMap.put(runic,"[\u16A0-\u16FF]");
UnitsMap.put(samaritan,"[\u0800-\u083F]");
UnitsMap.put(saurashtra,"[\uA880-\uA8DF]");
UnitsMap.put(sharada,"[\uD804\uDD80-\uD804\uDDDF]");
UnitsMap.put(shavian,"[\uD801\uDC50-\uD801\uDC7F]");
UnitsMap.put(sinhala,"[\u0D80-\u0DFF]");
UnitsMap.put(small_form_variants,"[\uFE50-\uFE6F]");
UnitsMap.put(sora_sompeng,"[\uD804\uDCD0-\uD804\uDCFF]");
UnitsMap.put(spacing_modifier_letters,"[\u02B0-\u02FF]");
UnitsMap.put(specials,"[\uFFF0-\uFFFF]");
UnitsMap.put(sundanese,"[\u1B80-\u1BBF]");
UnitsMap.put(sundanese_supplement,"[\u1CC0-\u1CCF]");
UnitsMap.put(superscripts_and_subscripts,"[\u2070-\u209F]");
UnitsMap.put(supplemental_arrows_a,"[\u27F0-\u27FF]");
UnitsMap.put(supplemental_arrows_b,"[\u2900-\u297F]");
UnitsMap.put(supplemental_mathematical_operators,"[\u2A00-\u2AFF]");
UnitsMap.put(supplemental_punctuation,"[\u2E00-\u2E7F]");
UnitsMap.put(supplementary_private_use_area_a,"[\uDB80\uDC00-\uDBBF\uDFFF]");
UnitsMap.put(supplementary_private_use_area_b,"[\uDBC0\uDC00-\uDBFF\uDFFF]");
UnitsMap.put(syloti_nagri,"[\uA800-\uA82F]");
UnitsMap.put(syriac,"[\u0700-\u074F]");
UnitsMap.put(tagalog,"[\u1700-\u171F]");
UnitsMap.put(tagbanwa,"[\u1760-\u177F]");
UnitsMap.put(tags,"[\uDB40\uDC00-\uDB40\uDC7F]");
UnitsMap.put(tai_le,"[\u1950-\u197F]");
UnitsMap.put(tai_tham,"[\u1A20-\u1AAF]");
UnitsMap.put(tai_viet,"[\uAA80-\uAADF]");
UnitsMap.put(tai_xuan_jing_symbols,"[\uD834\uDF00-\uD834\uDF5F]");
UnitsMap.put(takri,"[\uD805\uDE80-\uD805\uDECF]");
UnitsMap.put(tamil,"[\u0B80-\u0BFF]");
UnitsMap.put(telugu,"[\u0C00-\u0C7F]");
UnitsMap.put(thaana,"[\u0780-\u07BF]");
UnitsMap.put(thai,"[\u0E00-\u0E7F]");
UnitsMap.put(tibetan,"[\u0F00-\u0FFF]");
UnitsMap.put(tifinagh,"[\u2D30-\u2D7F]");
UnitsMap.put(transport_and_map_symbols,"[\uD83D\uDE80-\uD83D\uDEFF]");
UnitsMap.put(ugaritic,"[\uD800\uDF80-\uD800\uDF9F]");
UnitsMap.put(unassigned,"[\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF\u0000-\uFFFF]");
UnitsMap.put(unified_canadian_aboriginal_syllabics,"[\u1400-\u167F]");
UnitsMap.put(unified_canadian_aboriginal_syllabics_extended,"[\u18B0-\u18FF]");
UnitsMap.put(vai,"[\uA500-\uA63F]");
UnitsMap.put(variation_selectors,"[\uFE00-\uFE0F]");
UnitsMap.put(variation_selectors_supplement,"[\uDB40\uDD00-\uDB40\uDDEF]");
UnitsMap.put(vedic_extensions,"[\u1CD0-\u1CFF]");
UnitsMap.put(vertical_forms,"[\uFE10-\uFE1F]");
UnitsMap.put(yi_radicals,"[\uA490-\uA4CF]");
UnitsMap.put(yi_syllables,"[\uA000-\uA48F]");
UnitsMap.put(yijing_hexagram_symbols,"[\u4DC0-\u4DFF]");
}


private Pattern pattern;


public  String GreedyOnceOrNot( ){
    return "(?:"+UnitsMap.get(this)+")?";
}
public  String GreedyZeroOrMore( ){
    return "(?:"+UnitsMap.get(this)+")*";
}
public  String GreedyOneOrMore( ){
    return "(?:"+UnitsMap.get(this)+")+";
}
public  String GreedyExactN( int n){
    return "(?:"+UnitsMap.get(this)+"){"+n+"}";
}
public  String GreedyAtLeastN( int n){
    return "(?:"+UnitsMap.get(this)+"){"+n+",}";
}
public  String GreedyBoundary( int n,int m){
    return "(?:"+UnitsMap.get(this)+"){"+n+","+m+"}";
}
public  String ReluctantOnceOrNot( ){
    return "(?:"+UnitsMap.get(this)+")??";
}
public  String ReluctantZeroOrMore( ){
    return "(?:"+UnitsMap.get(this)+")*?";
}
public  String ReluctantOneOrMore( ){
    return "(?:"+UnitsMap.get(this)+")+?";
}
public  String ReluctantExactN( int n){
    return "(?:"+UnitsMap.get(this)+"){"+n+"}?";
}
public  String ReluctantAtLeastN( int n){
    return "(?:"+UnitsMap.get(this)+"){"+n+",}?";
}
public  String ReluctantBoundary( int n,int m){
    return "(?:"+UnitsMap.get(this)+"){"+n+","+m+"}?";
}
public  String PossessiveOnceOrNot( ){
    return "(?:"+UnitsMap.get(this)+")?+";
}
public  String PossessiveZeroOrMore( ){
    return "(?:"+UnitsMap.get(this)+")*+";
}
public  String PossessiveOneOrMore( ){
    return "(?:"+UnitsMap.get(this)+")++";
}
public  String PossessiveExactN( int n){
    return "(?:"+UnitsMap.get(this)+"){"+n+"}+";
}
public  String PossessiveAtLeastN( int n){
    return "(?:"+UnitsMap.get(this)+"){"+n+",}+";
}
public  String PossessiveBoundary( int n,int m){
    return "(?:"+UnitsMap.get(this)+"){"+n+","+m+"}+";
}



private String asPortableTxt(boolean jsCompatible,boolean doubleEscaped) {
String estr="\\u";
if(doubleEscaped){
estr="\\\\u";
}
StringBuilder stringBuilder = new StringBuilder("[");
StringBuilder forJS = new StringBuilder();
for (int[] ints : range()) {
int a = ints[0];
int b = ints[1];
assert b >= a;

if (a > 0xFFFF && jsCompatible) {
StringBuilder sb2 = new StringBuilder("");
List
<int[]> splits = split(a, b);
for (int[] split : splits) {
int aa = split[0];
int bb = split[1];
char[] range11 = Character.toChars(aa);
char[] range22 = Character.toChars(bb);
System.out.println("debug: split " + Integer.toHexString(range11[0]) + "  ==   " + Integer.toHexString(range22[0]));
if (aa == bb) {
sb2.append("|").append(estr).append(leftPadding(Integer.toHexString(range11[0]).toUpperCase()))
.append(estr)
.append(leftPadding(Integer.toHexString(range11[1]).toUpperCase()));
} else {
sb2.append("|")
.append(estr)
.append(leftPadding(Integer.toHexString(range11[0]).toUpperCase()))
.append("[").append(estr)
.append(leftPadding(Integer.toHexString(range11[1]).toUpperCase()))
.append("-").append(estr)
.append(leftPadding(Integer.toHexString(range22[1]).toUpperCase()))
.append("]");
}
}
forJS.append(sb2);

} else {
char[] range1 = Character.toChars(a);
char[] range2 = Character.toChars(b);
StringBuilder sb1 = new StringBuilder();
for (char c1 : range1) {
sb1.append(estr).append(CharacterEnhance.leftPadding(Integer.toHexString(c1).toUpperCase()));
}
sb1.append("-");
for (char c2 : range2) {
sb1.append(estr).append(CharacterEnhance.leftPadding(Integer.toHexString(c2).toUpperCase()));
}
stringBuilder.append(sb1);
}
}
stringBuilder.append("]");
String result;
if (stringBuilder.length() == 2) {
result =forJS.substring(1);
} else {
result= stringBuilder.append(forJS).toString();
}
boolean branch=result.contains("|");
if(branch){
result="(?:"+result+")";
}
return result;

}

public List
<int[]> split(int s, int e) {

assert s >= 0x10000;
assert s <= e;
assert e <= 0x10FFFF;
List
<int[]> result = new ArrayList<>();
int a = (s - 0x10000) % 0x400;
for (int i = s; i <= e; ) {
int start = i;
int end;
if (a > 0) {
end = Math.min(i + 0x3FF - a, e);
} else {
int t = e - e % 0x400;
end = (t == i ? e : t-1);
}
result.add(new int[]{start, end});
i = end + 1;
a = 0;
}
return result;
}


public String asRegex() {
return UnitsMap.get(this);
}

public String pattern() {
return asPortableTxt(false,false);
}

public String asJSCompatible() {
return asPortableTxt(true,false);
}

public String doubleEscaped() {
return asPortableTxt(false, true);
}

public String doubleEscapedJs() {
return asPortableTxt(true, true);
}


public  List
<int[]> range() {
String sc=UnitsMap.get(this);
List
<int[]> lc = new ArrayList<>();
for (int i = 1; i < sc.length() - 1; ) {
int start;
int end;
if (Character.isHighSurrogate(sc.charAt(i))) {
start = ((sc.charAt(i) - 0xD800) << 10) + (sc.charAt(i + 1) - 0xDC00) + 0x10000;
end = ((sc.charAt(i + 3) - 0xD800) << 10) + (sc.charAt(i + 4) - 0xDC00) + 0x10000;
i = i + 5;
} else {
start = sc.charAt(i);
end = sc.charAt(i + 2);
i = i + 3;
}
lc.add(new int[]{
start, end
});
}
return lc;
}

public  String prettyRange(){
StringBuilder sb=new StringBuilder();
for (int[] ints : range()) {
for (int anInt : ints) {
String r=Integer.toHexString(anInt);
switch (r.length()){
case 4:
sb.append(r).append("      >      ");
break;
case 5:
sb.append(r).append("     >     ");
break;
case 6:
sb.append(r).append("    >    ");
}

}
sb.append("\n");
}
return sb.toString().replaceAll("(?m)[\\s>]*$","");
}

/**
* 此处内容来自维基百科<a href="http://zh.wikipedia.org/wiki/Unicode%E5%AD%97%E7%AC%A6%E5%B9%B3%E9%9D%A2%E6%98%A0%E5%B0%84">unicode字符平面映射</a>
* 0号平面    U+0000 - U+FFFF    基本多文种平面    Basic Multilingual Plane,简称BMP
* 1号平面    U+10000 - U+1FFFF    多文种补充平面    Supplementary Multilingual Plane,简称SMP
* 2号平面    U+20000 - U+2FFFF    表意文字补充平面    Supplementary Ideographic Plane,简称SIP
* 3号平面    U+30000 - U+3FFFF    表意文字第三平面（未正式使用[1]）    Tertiary Ideographic Plane,简称TIP
* 4号平面
* 至
* 13号平面    U+40000 - U+DFFFF    （尚未使用）
* 14号平面    U+E0000 - U+EFFFF    特别用途补充平面    Supplementary Special-purpose Plane,简称SSP
* 15号平面    U+F0000 - U+FFFFF    保留作为私人使用区（A区）[2]    Private Use Area-A,简称PUA-A
* 16号平面    U+100000 - U+10FFFF    保留作为私人使用区（B区）[2]    Private Use Area-B,简称PUA-B
*/

public String joinBMPCodePoints() {
StringBuilder sb = new StringBuilder();
List
<int[]> list = range();
for (int[] ints : list) {
for (int i = ints[0]; i <= ints[1]; i++) {
if (i <= 0xFFFF) {
sb.append(((char) i));
}
}
}
return sb.toString();
}


public boolean matches(String target){
if(target==null||target.isEmpty()){
return false;
}else {
return target.matches(GreedyOneOrMore());
}
}

private Pattern getPattern(){
if (pattern == null) {
pattern = Pattern.compile(GreedyOneOrMore());
}
return pattern;
}
public List
<String> extract(String target) {
    assert target != null;
    List
    <String> result = new ArrayList
        <String>();

            Matcher m = getPattern().matcher(target);
            while (m.find()) {
            result.add(m.group());
            }
            return result;
            }

            public boolean find(String target){
            Matcher m=getPattern().matcher(target);
            if(m.find()){
            return true;
            }else {
            return false;
            }
            }

            public static String toPortableRegex(String javaRegex,final boolean jsCompatible, final boolean
            doubleEscaped) {
            String p = RegexUtil.replace(javaRegex, "\\Q\\p{\\E(I[ns])([^}]*)\\Q}\\E", new Replacement() {
            @Override
            public String format(Matcher m) {
            switch (m.group(1)) {
            case "Is":

            return EasyUnicode.valueOf(m.group(2).toUpperCase()).asPortableTxt(jsCompatible,doubleEscaped);
            case "In":
            return EasyUnicode.valueOf(m.group(2).toLowerCase()).asPortableTxt(jsCompatible, doubleEscaped);
            default:
            return m.group(0);
            }
            }
            });
            return p;
            }

            public static String leftPadding(String s) {
            String t = ("0000" + s);
            return t.substring(t.length() - 4);
            }

            }
