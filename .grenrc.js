module.exports = {
    "prefix": "Release ",
    "data-source":"prs",
    "only-milestones":true,
    "ignoreCommitsWith": [
        "prepare",
        "release"
    ],
    "groupBy": {
        "Enhancements:": ["enhancement", "internal"],
        "Bug Fixes:": ["bug"]
    },
    "template": {
        "issue": "- [{{text}}]({{url}}) {{name}}",
        "commit": "- {{message}}",
	"changelogTitle": "# Changelog\n\n",
        "release": "## {{release}} ({{date}})\n{{body}}",
	"releaseSeparator": "\n---\n\n"
    }
};
